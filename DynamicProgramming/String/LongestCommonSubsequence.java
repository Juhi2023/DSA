import java.util.*;

public class LongestCommonSubsequence{

    //Brute Forcce
    //Time Complexity: O((N+M)*2^N)
    //Space Complexity: O((2^N)
    static boolean isSubsequence(String sub, String str) {
        int j = 0;
        for (int i = 0; i < str.length() && j < sub.length(); i++) {
            if (sub.charAt(j) == str.charAt(i)) {
                j++;
            }
        }
        return j == sub.length();
    }

    static List<String> getAllSubsequences(String s) {
        List<String> subsequences = new ArrayList<>();
        int n = s.length();
        int total = 1 << n; 

        for (int i = 1; i < total; i++) { 
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    sb.append(s.charAt(j));
                }
            }
            subsequences.add(sb.toString());
        }

        return subsequences;
    }

    static String LCS(String s1, String s2) {
        List<String> subs = getAllSubsequences(s1);
        String longest = "";

        for (String sub : subs) {
            if (isSubsequence(sub, s2) && sub.length() > longest.length()) {
                longest = sub;
            }
        }

        return longest;
    }

    //Memoization
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static int helper(int n, int m, String str1, String str2, int dp[][], int i, int j) {
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(str1.charAt(i)==str2.charAt(j)){
            return dp[i][j] = 1 + helper(n, m, str1,  str2, dp, i-1, j-1);
        }
        return dp[i][j] = Math.max(helper(n, m,  str1, str2, dp, i-1, j),  helper(n, m,  str1, str2, dp, i, j-1));
    }

    static int LCSMemo(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int dp[][]= new int[n][m];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        helper(n, m, str1, str2, dp, n-1, m-1);
        int len = dp[n-1][m-1];
        int i=n-1;
        int j=m-1;

        
        StringBuilder lcs = new StringBuilder();

        while (i >= 0 && j >= 0) {
            if (str1.charAt(i) == str2.charAt(j)) {
                lcs.append(str1.charAt(i));
                i--;
                j--;
            } else {
                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;

                if (up > left) 
                    i--;
                else 
                    j--;
            }
        }
        System.out.println(lcs.reverse());

        return dp[n-1][m-1];
    }


    //Tabulation
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static int LCSTab(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int dp[][]= new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }

    //SO
    //Time Complexity: O(N*M)
    //Space Complexity: O((N)
    static int LCSSO(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int prev[]= new int[m+1];
        for(int i=1; i<=n; i++){
            int temp[]= new int[m+1];
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    temp[j] = 1 + prev[j - 1];
                }else{
                    temp[j] = Math.max(temp[j - 1], prev[j]);
                }
            }
            prev=temp;
        }
        return prev[m];
    }


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int lcs = LCSMemo(s1, s2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
