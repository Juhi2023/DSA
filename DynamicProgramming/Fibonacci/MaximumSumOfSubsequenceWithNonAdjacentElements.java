import java.util.*;

class MaximumSumOfSubsequenceWithNonAdjacentElements{
    //Recursion
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)
    public static int helper(int ind, int arr[]) {
        if (ind < 0) 
            return 0;
        int pick = arr[ind] + helper(ind - 2, arr);
        int nonPick = helper(ind - 1, arr);
        return Math.max(pick, nonPick);
    }

    public static int getSum(int arr[]){
        return helper(arr.length-1, arr);
    }

    //Memoization
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int helper(int arr[], int ind, int dp[]) {
        if (ind < 0) 
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int pick = arr[ind] + helper( arr,ind - 2, dp);
        int nonPick = helper(arr, ind - 1, dp);
        return dp[ind] = Math.max(pick, nonPick);
    }

    public static int getSumByMemo(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(arr, n-1, dp);
    }

    //Tabulation
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int getSumByTab(int arr[]){
        int n =arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        
        dp[0] = Math.max(0, arr[0]);
        
        for(int i=1; i<n; i++){
            int pick = arr[i];
            if(i>1)
                pick+=dp[i-2];
            int nonPick = dp[i-1];
            dp[i]= Math.max(pick, nonPick);
        }
        return dp[n - 1];
    }

    //Space Optimization
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int getSumBySO(int arr[]){
        int n =arr.length;
        int prev1=0;
        int prev2 = Math.max(0, arr[0]);
        
        for(int i=1; i<n; i++){
            int pick = arr[i];
            pick+=prev1;
            int nonPick = prev2;

            prev1 = prev2;
            prev2= Math.max(pick, nonPick);
        }
        return prev2;
    }

    public static void main(String args[]){
        System.out.println(getSumBySO(new int[]{2, 1, 4, 9}));
    }
}