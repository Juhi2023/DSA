import java.util.*;

public class DistinctSubsequences{
    //Memoization
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static int helper(String str1, String str2, int i1, int i2, int dp[][]){
        if(i2<0){
            return 1;
        }
        if(i1<0){
            return 0;
        }
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        int ans=0;
        if(str1.charAt(i1)==str2.charAt(i2)){                                                   
            ans = helper(str1, str2, i1-1, i2-1, dp);
        }
        ans += helper(str1, str2, i1-1, i2, dp);

        return dp[i1][i2] = ans;
    }
    static int distinctSequences(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n][m];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        
        return helper(str1, str2, n-1, m-1, dp);
    }

    //Tabulation
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static int distinctSequencesTab(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=m; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                dp[i][j]+= dp[i-1][j];
            }
        }
        
        return dp[n][m];
    }

    //SO
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static int distinctSequencesSO(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int prev[]=new int[m+1];
        prev[0] = 1;

        for(int i=1; i<=n; i++){        
            int temp[]=new int[m+1];
            temp[0]=1;
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    temp[j] = prev[j-1];
                temp[j]+= prev[j];
            }
            prev=temp;
        }
        
        return prev[m];
    }

    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2= "bag";
        int ans = distinctSequencesTab(s1, s2);
        System.out.println(ans);
    }
}
