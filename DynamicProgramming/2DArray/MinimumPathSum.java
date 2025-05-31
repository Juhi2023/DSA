import java.util.*;

class MinimumPathSum {
    //Memoization
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public static int helper(int[][] grid, int dp[][], int n, int m, int x, int y) {
        if(x<0 || y<0){
            return -1;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }

        if(x==0 && y==0)
            return dp[0][0]=grid[0][0];

        int up =helper(grid, dp, n ,n , x-1, y);
        int left =helper(grid, dp, n ,n , x, y-1);

        if(up==-1){
            return dp[x][y]=grid[x][y] + left;
        }else if(left==-1){
            return dp[x][y]=grid[x][y] + up;
        }
        return dp[x][y] = grid[x][y] + Math.min(up, left);
    }

    public static int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int dp[][]=new int[n][m];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        return helper(grid, dp, n, m, n-1, m-1);
    }
    //Tabulation
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public static int minPathSumTab(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int dp[][]=new int[n][m];
        for(int x[]: dp){
            Arrays.fill(x, 0);
        }
        dp[0][0]=grid[0][0];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0){
                    continue;
                }

                if(i==0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else if(j==0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n-1][m-1];
    }

    //Space Optimization
    // Time Complexity: O(N*M)
    // Space Complexity: O(N)
    public static int minPathSumSO(int grid[][]) {
        int n=grid.length;
        int m=grid[0].length;

        int prev[]=new int[m];
        Arrays.fill(prev, 0);

        for(int i=0; i<n; i++){
            int temp[]=new int[m];
            for(int j=0; j<m; j++){
                if(i==0 && j==0){
                    temp[0]=grid[0][0];
                    continue;
                }

                if(i==0){
                    //left
                    temp[j] = grid[i][j] + temp[j-1];
                }else if(j==0){
                    //top
                    temp[j] = grid[i][j] + prev[j];
                }else{
                    temp[j] = grid[i][j] + Math.min(temp[j-1], prev[j]);
                }
            }
            prev=temp;
        }

        return prev[m-1];
    }

    public static void main(String args[]) {

        System.out.println(minPathSum(new int[][]{
            { 1, 2, 3 },
            { 4, 8, 2 },
            { 1, 5, 3 }
        })); 
    }
}

