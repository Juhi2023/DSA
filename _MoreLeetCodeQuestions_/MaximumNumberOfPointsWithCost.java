//https://leetcode.com/problems/maximum-number-of-points-with-cost/description/
// 
//Memoization
// Time Complexity: O(N*M*M)
// Space Complexity: O(N*M)
class Solution {
    public long helper(int[][] points, long dp[][], int n, int m, int i, int j) {
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(i==n-1){
            return dp[i][j] = (long)(points[i][j]);
        }

        long ans=Long.MIN_VALUE;
        for(int k=0; k<m; k++){
            ans = Math.max(ans,  (long)(points[i][j])+helper(points, dp, n, m, i+1, k)- Math.abs(j-k));
        }
        return dp[i][j] = ans;
    }
    public long maxPoints(int[][] points) {
        int n=points.length;
        int m = points[0].length;
        long dp[][]= new long[n][m];
        for(long x[]: dp){
            Arrays.fill(x, -1);
        }
        long ans=Long.MIN_VALUE;
        for(int i=0; i<m; i++){
            ans = Math.max(ans, helper(points, dp, n, m, 0, i));
        }
        return ans;
    }
}

//Memoization + left + right max
// Time Complexity: O(N*M)
// Space Complexity: O(N*M)
class Solution {
    int[][] points;
    long[][] dp;
    int n, m;

    public long helper(int row, int col) {
        if (row == n - 1) return points[row][col];
        if (dp[row][col] != -1) return dp[row][col];

        // Precompute maxLeft and maxRight only once per row
        if (row + 1 < n) {
            long[] next = new long[m];
            for (int j = 0; j < m; j++) {
                next[j] = helper(row + 1, j);
            }

            long[] leftMax = new long[m];
            long[] rightMax = new long[m];

            leftMax[0] = next[0];
            for (int j = 1; j < m; j++) {
                leftMax[j] = Math.max(leftMax[j - 1] - 1, next[j]);
            }

            rightMax[m - 1] = next[m - 1];
            for (int j = m - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1] - 1, next[j]);
            }

            for (int j = 0; j < m; j++) {
                dp[row][j] = points[row][j] + Math.max(leftMax[j], rightMax[j]);
            }
        }

        return dp[row][col];
    }

    public long maxPoints(int[][] points) {
        this.points = points;
        this.n = points.length;
        this.m = points[0].length;
        this.dp = new long[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        long result = 0;
        for (int j = 0; j < m; j++) {
            result = Math.max(result, helper(0, j));
        }

        return result;
    }
}
