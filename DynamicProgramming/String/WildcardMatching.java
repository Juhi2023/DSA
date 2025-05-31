import java.util.*;

public class WildcardMatching{
    //Memoization
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
        if (S1.charAt(j) != '*')
            return false;
        }
        return true;
    }

    static boolean helper(String s, String p, int i, int j, Boolean dp[][]){
        if(i<0 && j<0){
            return true;
        }
        if(j<0){
            return false;
        }
        if(i<0){
            if(isAllStars(p, j)){
                return true;
            }
            return false;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if((s.charAt(i)==p.charAt(j)) || p.charAt(j)=='?'){
            return dp[i][j] = helper(s, p, i-1, j-1, dp);
        }
        if(p.charAt(j)=='*'){
            return dp[i][j] = helper(s, p, i-1, j, dp) || helper(s, p, i, j-1, dp);
        }
        return dp[i][j] = false;
    }

    static boolean matching(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean dp[][]=new Boolean[n][m];
        return helper(s, p, n-1, m-1, dp);
    }

    //Tabulation
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static boolean matchingTab(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = isAllStars(p, j-1);
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }
        

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1)==p.charAt(j-1)|| p.charAt(j-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]= dp[i-1][j]|| dp[i][j-1];
                }
            }
        }
        
        return dp[n][m];
    }

    //SO
    //Time Complexity: O(N*M)
    //Space Complexity: O((N*M)
    static boolean matchingSO(String s, String p) {
            
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String s2= "*";
        boolean ans = matchingSO(s1, s2);
        System.out.println(ans);
    }
}
