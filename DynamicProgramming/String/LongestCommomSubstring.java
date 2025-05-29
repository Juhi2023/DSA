import java.util.*;

public class LongestCommomSubstring{

    //Memoization
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static int maxLength=0;
    static int helper( String str1, String str2, int dp[][], int i, int j) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        helper(str1, str2, dp, i - 1, j);     // explore without matching
        helper(str1, str2, dp, i, j - 1);   

        if (str1.charAt(i) == str2.charAt(j)) {
            int result = 1 + helper(str1, str2, dp, i - 1, j - 1);
            maxLength = Math.max(maxLength, result);
            dp[i][j] = result;
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }

    static int LCSMemo(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int dp[][]= new int[n][m];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        helper(str1, str2, dp, n-1, m-1);
        return maxLength;
    }


    //Tabulation
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static int LCSTab(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int dp[][]= new int[n+1][m+1];
        int ans=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans=Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    //SO
    //Time Complexity: O(N*M)
    //Space Complexity: O((N)
    static int LCSSO(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int prev[]= new int[m+1];
        int ans=0;
        for(int i=1; i<=n; i++){
            int temp[]= new int[m+1];
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    temp[j] = 1 + prev[j - 1];
                    ans=Math.max(ans, temp[j]);
                }else{
                    temp[j] = 0;
                }
            }
            prev=temp;
        }
        return ans;
    }


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abe";
        int lcs = LCSSO(s1, s2);
        System.out.println("Longest Common Substring: " + lcs);
    }
}
