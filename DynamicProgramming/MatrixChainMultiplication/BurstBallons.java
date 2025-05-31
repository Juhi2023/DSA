import java.util.*;

class BurstBallons {
    //Mmoization
    //Time Complexity: O(N*N*N)
    //Space Complexity: O((N*N)
    public static int helper(int[] nums, int l, int r, int dp[][]) {
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int max = Integer.MIN_VALUE;
        for(int i=l; i<=r; i++){
            int coins = nums[l-1]*nums[i]*nums[r+1] + helper(nums, l, i-1, dp) + helper(nums, i+1, r, dp);
            max = Math.max(max, coins);
        }

        return dp[l][r]=max;
    }

    static int maxCoins(int nums[], int n) {
        int newNums[] = new int [n+2];
        newNums[0]=newNums[n+1]=1;
        for(int i=1; i<=n; i++){
            newNums[i] = nums[i-1];
        }
        int dp[][] = new int[n+2][n+2];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        return helper(newNums, 1, n, dp);
    }

    //Tabulation
    //Time Complexity: O(N*N*N)
    //Space Complexity: O((N*N)
    static int maxCoinsTab(int nums[], int n) {
        int newNums[] = new int [n+2];
        newNums[0]=newNums[n+1]=1;
        for(int i=1; i<=n; i++){
            newNums[i] = nums[i-1];
        }
        int dp[][] = new int[n+2][n+2];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int max=Integer.MIN_VALUE;
                for(int k=i; k<=j; k++){
                    int ans = dp[i][k-1] + dp[k+1][j] + (newNums[i-1] * newNums[k] * newNums[j+1] );
                    max = Math.max(max, ans);
                }
                dp[i][j] = max;
            }
        }
        
        return dp[1][n];
    }

    public static void main(String args[]) {
        int arr[] = {3,1,5,8 };
        int n = arr.length;
        System.out.println(maxCoinsTab(arr, n));
    }
}