
import java.util.*;

class CoinChange2 {
    //Memoization
    // Time Complexity: O(N*T)
    // Space Complexity: O(N*T)
    static int coinChangeUtil(int[] coins, int n, int amount, int dp[][]) {
        if(amount==0)
            return 1;
        if(n==0){
            return amount==0 ? 1:0;
        }
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }
        int notTaken = coinChangeUtil(coins, n-1, amount, dp);
        int taken=0;
        if(coins[n-1]<=amount){
            taken = coinChangeUtil(coins, n, amount - coins[n - 1], dp);
        }
        return dp[n][amount] = notTaken + taken;
    }

    static int coinChange(int[] coins, int n) {
        int m=coins.length;
        int dp[][]=new int[m+1][n+1];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        int ans=coinChangeUtil(coins, m, n, dp);
        return ans;
    }

    //Tabulation
    // Time Complexity: O(N*T)
    // Space Complexity: O(N*T)
    static int coinChangeTab(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]= new int[n+1][amount+1];
        dp[0][0]=1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<=amount; j++){
                int notTaken = dp[i-1][j];
                int taken=0;
                if(coins[i-1]<=j){
                    taken = dp[i][j-coins[i-1]];
                }
                dp[i][j]=taken+notTaken;
            }
        }
        return dp[n][amount];
    }

    //Space Optimization
    // Time Complexity: O(N*T)
    // Space Complexity: O(W)
    static int coinChangeSO(int[] coins, int amount) {
        int prev[]= new int[amount+1];
        prev[0]=1;
        int n=coins.length;
        for(int i=1; i<=n; i++){
            int temp[]= new int[amount+1];
            for(int j=0; j<=amount; j++){
                int notTaken = prev[j];
                int taken=0;
                if(coins[i-1]<=j){
                    taken = temp[j-coins[i-1]];
                }
                temp[j]=taken+notTaken;
            }
            prev=temp;
        }
        return prev[amount];
    }

    public static void main(String args[]) {
        int coins[] = {1, 2, 5};
        int W = 5;
        int n = 11;

        System.out.println(coinChangeTab(coins, n));
    }
}

