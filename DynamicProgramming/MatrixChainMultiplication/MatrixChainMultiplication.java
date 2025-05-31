import java.util.*;

class MatrixChainMultiplication {
    //Mmoization
    //Time Complexity: O(N*N*N)
    //Space Complexity: O((N*N)
    public static int helper(int nums[], int i, int j, int dp[][]){
        if(i==j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int ans = helper(nums, i, k, dp) + helper(nums, k+1, j, dp) + (nums[i-1] * nums[k] * nums[j] );
            min = Math.min(min, ans);
        }
        return dp[i][j] = min;
    }

    static int minOperations(int nums[], int n) {
        int dp[][]=new int[n][n];
        for(int x[]: dp){
            Arrays.fill(x,-1);
        }
        return helper(nums, 1, n-1, dp);
    }

    //Tabulation
    //Time Complexity: O(N*N*N)
    //Space Complexity: O((N*N)
    static int minOperationsTab(int nums[], int n) {
        int dp[][]=new int[n][n];

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min=Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int ans = dp[i][k] + dp[k+1][j] + (nums[i-1] * nums[k] * nums[j] );
                    min = Math.min(min, ans);
                }
                dp[i][j] = min;
            }
        }
        
        return dp[1][n-1];
    }

    public static void main(String args[]) {
        int arr[] = {2, 1, 3, 4 };
        int n = arr.length;
        System.out.println(minOperationsTab(arr, n));
    }
}