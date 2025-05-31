import java.util.*;

class ClimbingStairs{
    //Recursion
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)
    public static int getWays(int n){
        if(n<=2)
            return n;
        return getWays(n-1) + getWays(n-2);
    }

    //Memoization
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int helper(int n, int dp[]) {
        if(n<=1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        
        return dp[n]=helper(n-1, dp) + helper(n-2, dp);
    }

    public static int getWaysByMemo(int n){
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        helper(n, dp);
        return dp[n];
    }

    //Tabulation
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int getWaysByTab(int n){
        if(n<=2)
            return n;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //Space Optimization
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int getWaysBySO(int n){
        if(n<=2)
            return n;
        
        int prev1 = 1;
        int prev2 = 2;
        
        for(int i=3; i<=n; i++){
            int curr = prev1+prev2;
            prev1=prev2;
            prev2=curr;
        }
        return prev2;
    }


    public static void main(String args[]){
        System.out.println(getWaysBySO(5));
    }
}