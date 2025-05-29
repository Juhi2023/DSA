import java.util.*;

class MinimumFallingPathSum {
    //Memoization
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public static int helper(int[][] matrix, int dp[][], int n, int m, int i, int j) {
        if(i<0 || j<0 || i>=n || j>=m){
            return Integer.MAX_VALUE;
        }

        if(i==n-1){
            return dp[i][j] = matrix[i][j];
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=Integer.MAX_VALUE;
        for(int k=-1; k<2; k++){
            ans = Math.min(ans, helper(matrix, dp, n, m, i+1, j+k));
        }
        return dp[i][j] = matrix[i][j]+ans;
    }

    public static int minPathSum(int[][] matrix) {
        int n=matrix.length;
        int m = matrix[0].length;
        int dp[][]= new int[n][m];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            ans = Math.min(ans, helper(matrix, dp, n, m, 0, i));
        }
        return ans;
    }
    //Tabulation
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public static int minPathSumTab(int[][] matrix) {
        int n=matrix.length;

        int dp[][]=new int[n][n];
        for(int x[]: dp){
            Arrays.fill(x, 0);
        }
        for(int i=0; i<n; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int temp=Integer.MAX_VALUE;
                if(j>0){
                    temp = Math.min(temp, dp[i-1][j-1]);
                }
                temp = Math.min(temp, dp[i-1][j]);
                if(j<n-1){
                    temp = Math.min(temp, dp[i-1][j+1]);
                }
                dp[i][j] = matrix[i][j] + temp;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }

    //Space Optimization
    // Time Complexity: O(N*M)
    // Space Complexity: O(N)
    public static int minPathSumSO(int matrix[][]) {
        int n=matrix.length;
        int prev[]=new int[n];
        for(int i=0; i<n; i++){
            prev[i] = matrix[0][i];
        }

        for(int i=1; i<n; i++){
            int temp[]= new int[n];
            for(int j=0; j<n; j++){
                int t=Integer.MAX_VALUE;
                if(j>0){
                    t = Math.min(t, prev[j-1]);
                }
                t = Math.min(t, prev[j]);
                if(j<n-1){
                    t = Math.min(t, prev[j+1]);
                }
                temp[j] = matrix[i][j] + t;
            }
            prev=temp;
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.min(ans, prev[i]);
        }
        return ans;
    }

    public static void main(String args[]) {
        System.out.println(minPathSum(new int[][]{
            { 1, 2, 3 },
            { 4, 8, 2 },
            { 1, 5, 3 }
        })); 
    }
}

