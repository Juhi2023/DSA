

import java.util.Arrays;

class BuyAndsellStocks2 {
    //Memoization
    // Time Complexity: O(N*2)
    // Space Complexity: O(N*2)
    static long helper(long []Arr, int ind, int buy, int n, long [][]dp){
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        long profit = 0;
        if(buy==0){
            profit = Math.max( helper(Arr, ind+1, 0, n, dp), -Arr[ind]+helper(Arr, ind+1, 1, n, dp));
        }
        if(buy==1){
            profit = Math.max( helper(Arr, ind+1, 1, n, dp), Arr[ind]+helper(Arr, ind+1, 0, n, dp));
        }
        return dp[ind][buy] = profit;
    }
    static long getMaximumProfit(long[] Arr, int n) {
        long[][] dp = new long[n + 1][2];
        for(long x[]: dp){
            Arrays.fill(x, -1);
        }
        return helper(Arr, 0, 0, n, dp);
    }
    
    //Tabulation
    // Time Complexity: O(N*2)
    // Space Complexity: O(N*2)
    static long getMaximumProfitTab(long[] Arr, int n) {
        long[][] dp = new long[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        long profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { 
                    profit = Math.max(dp[ind + 1][1], Arr[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }

    //Space Optimization
    // Time Complexity: O(N*2)
    // Space Complexity: O(2)
    static long getMaximumProfitSO(long[] Arr, int n) {
        long[] prev= new long[2];
        prev[0] = prev[1] = 0;

        long profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            long[] temp= new long[2];
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + prev[0], -Arr[ind] + prev[1]);
                }

                if (buy == 1) { 
                    profit = Math.max(0 + prev[1], Arr[ind] + prev[0]);
                }

                temp[buy] = profit;
            }
            prev=temp;
        }
        return prev[0];
    }

    public static void main(String args[]) {
        int n = 6;
        long[] Arr = {7, 1, 5, 3, 6, 4};
        System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
    }
}


