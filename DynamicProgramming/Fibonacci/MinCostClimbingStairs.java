import java.util.*;

class MinCostClimbingStairs{
    //Recursion
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)
    public static int helper(int cost[], int i) {
        if(i>=cost.length)
            return 0;
        int a = helper(cost, i+1);
        int b = helper(cost, i+2);
        
        return Math.min(a,b)+cost[i];
    }

    public static int getMinCost(int cost[]){
        return Math.min(helper(cost,0) , helper(cost,1));
    }

    //Memoization
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int helper(int cost[], int i, int dp[]) {
        if (i < 0) return 0;
        if (i == 0 || i == 1) return cost[i];

        if (dp[i] != -1) return dp[i];

        dp[i] = cost[i] + Math.min(dp(cost, i - 1, dp), dp(cost, i - 2, dp));
        return dp[i]
    }

    public static int getMinCostByMemo(int cost[]){
        int dp[] = new int[cost.length];
        int n = cost.length;
        Arrays.fill(dp, -1);
        return Math.min( helper(cost,n-1 , dp),   helper(cost, n-2, dp));
    }

    //Tabulation
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int getMinCostByTab(int cost[]){
        int n =cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i=2; i<n; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return dp[n-1];
    }

    //Space Optimization
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int getMinCostBySO(int cost[]){
        int n =cost.length;
        int prev1 = cost[0];
        int prev2 = cost[1];
        
        for(int i=2; i<n; i++){
            int curr = Math.min(prev1, prev2) + cost[i];
            prev1=prev2;
            prev2= curr;
        }
        return prev2;
    }

    public static void main(String args[]){
        System.out.println(getMinCostBySO(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}