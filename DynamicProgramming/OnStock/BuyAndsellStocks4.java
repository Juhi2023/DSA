

import java.util.Arrays;

class BuyAndsellStocks4 {
    //Memoization
    // Time Complexity: O(N*2*K)
    // Space Complexity: O(N*2*K)
    static long helper(long []Arr, int ind, int buy, int cap, int n, long [][][]dp){
        if(ind==n || cap==0){
            return 0;
        }
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        long profit = 0;
        if(buy==0){
            profit = Math.max( helper(Arr, ind+1, 0, cap, n, dp), -Arr[ind]+helper(Arr, ind+1, 1, cap, n, dp));
        }
        if(buy==1){
            profit = Math.max( helper(Arr, ind+1, 1, cap, n, dp), Arr[ind]+helper(Arr, ind+1, 0, cap-1, n, dp));
        }
        return dp[ind][buy][cap] = profit;
    }

    static long getMaximumProfit(long[] Arr, int n, int k) {
        long[][][] dp = new long[n + 1][2][k+1];
        for(long x[][]: dp){
            for(long y[]: x){
                Arrays.fill(y, -1);
            }
        }
        return helper(Arr, 0, 0, k, n, dp);
    }
    
    //Tabulation
    // Time Complexity: O(N*2*K)
    // Space Complexity: O(N*2*K)
    static long getMaximumProfitTab(long[] Arr, int n, int k) {
        long[][][] dp = new long[n + 1][2][k+1];
        for(int i=0; i<=n; i++){
            for(int cap=0; cap<=k; cap++){
                dp[n][0][cap] = dp[n][1][cap] = 0;
            }
        }

        long profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for(int cap=1; cap<=k; cap++){
                    if (buy == 0) { // We can buy the stock
                        profit = Math.max(dp[ind + 1][0][cap], -Arr[ind] + dp[ind + 1][1][cap]);
                    }

                    if (buy == 1) { 
                        profit = Math.max(dp[ind + 1][1][cap], Arr[ind] + dp[ind + 1][0][cap-1]);
                    }

                    dp[ind][buy][cap] = profit;
                }
            }
        }
        return dp[0][0][k];
    }

    //Space Optimization
    // Time Complexity: O(N*2*K)
    // Space Complexity: O(N*2)
    static long getMaximumProfitSO(long[] Arr, int n, int k) {
        long[][] prev= new long[2][k+1];

        long profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            long[][] temp= new long[2][k+1];
            for (int buy = 0; buy <= 1; buy++) {
                for(int cap=1; cap<=k; cap++){

                    if (buy == 0) { // We can buy the stock
                        profit = Math.max(0 + prev[0][cap], -Arr[ind] + prev[1][cap]);
                    }

                    if (buy == 1) { 
                        profit = Math.max(0 + prev[1][cap], Arr[ind] + prev[0][cap-1]);
                    }

                    temp[buy][cap] = profit;
                }
            }
            prev=temp;
        }
        return prev[0][k];
    }

    public static void main(String args[]) {
        int n = 6;
        long[] Arr = {7, 1, 5, 3, 6, 4};
        System.out.println("The maximum profit that can be generated is " + getMaximumProfitSO(Arr, n, 2));
    }
}


