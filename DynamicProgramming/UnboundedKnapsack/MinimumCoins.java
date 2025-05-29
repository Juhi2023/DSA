
import java.util.*;

class MinimumCoins {
    //Memoization
    // Time Complexity: O(N*T)
    // Space Complexity: O(N*T)
    static int minimumCoinsUtil(int[] coins, int n, int m, int dp[][]) {
        if(m==0){
            return n==0 ? 0: (int) Math.pow(10, 9);
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int notTaken = minimumCoinsUtil(coins, n, m-1, dp);
        int taken=(int) Math.pow(10, 9);
        if(coins[m-1]<=n){
            taken = 1 + minimumCoinsUtil(coins, n - coins[m - 1], m, dp);
        }
        return dp[m][n] = Math.min(notTaken, taken);
    }

    static int minimumCoins(int[] coins, int n) {
        int m=coins.length;
        int dp[][]=new int[m+1][n+1];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        int ans=minimumCoinsUtil(coins, n, m, dp);
        return ans== (int) Math.pow(10, 9) ? -1 : ans;
    }

    //Tabulation
    // Time Complexity: O(N*T)
    // Space Complexity: O(N*T)
    static int minimumCoinsTab(int[] coins, int n) {
        int m=coins.length;
        int dp[][]=new int[m+1][n+1];
        Arrays.fill(dp[0], (int)(Math.pow(10,9)));
        dp[0][0]=0;
        for(int i=1; i<=m; i++){
            for(int am=0; am<=n; am++){
                int notTaken=dp[i-1][am];
                int taken = (int)(Math.pow(10,9));
                if(coins[i-1]<=am){
                    taken = 1 + dp[i][am-coins[i-1]];
                }
                dp[i][am] = Math.min(notTaken, taken);
            }
        }
        return dp[m][n]==(int)(Math.pow(10,9)) ? -1: dp[m][n];
    }

    //Space Optimization
    // Time Complexity: O(N*T)
    // Space Complexity: O(W)
    static int minimumCoinsSO(int[] coins, int n) {
        int m=coins.length;
        int prev[]=new int[n+1];
        Arrays.fill(prev, (int)(Math.pow(10,9)));
        prev[0]=0;
        for(int i=1; i<=m; i++){
            int temp[]=new int[n+1];
            for(int am=coins[i-1]; am<=n; am++){
                int notTaken=prev[am];
                int taken = (int)(Math.pow(10,9));
                if(coins[i-1]<=am){
                    taken = 1 + temp[am-coins[i-1]];
                }
                temp[am] = Math.min(notTaken, taken);
            }
            prev=temp;
        }
        return prev[n]==(int)(Math.pow(10,9)) ? -1: prev[n];
    }

    public static void main(String args[]) {
        int coins[] = {1, 2, 5};
        int W = 5;
        int n = 11;

        System.out.println(minimumCoinsTab(coins, n));
    }
}

