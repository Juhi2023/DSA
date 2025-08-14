//https://leetcode.com/problems/minimum-path-cost-in-a-grid/description/

//Memoization
//Time Complexity: O(N*N*M)
//Space Complexity: O(N*M)
class Solution {
    public int helper(int row, int col, int grid[][], int moves[][], int n, int m, int dp[][]) {
        if (row == n - 1) return grid[row][col];
        if (dp[row][col] != -1) return dp[row][col];

        int ans=Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans =  Math.min(ans, grid[row][col] + helper(row+1, j, grid, moves, n, m, dp)+moves[grid[row][col]][j]);
            
        }

        return dp[row][col]=ans;
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length;
        int m = grid[0].length;

        int dp [][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            result = Math.min(result, helper(0, j, grid, moveCost, n, m, dp));
        }

        return result;
    }
}


//Tabulation
//Time Complexity: O(N*N*M)
//Space Complexity: O(N*M)
class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length;
        int m = grid[0].length;

        int dp [][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < m; i++) {
            dp[n-1][i]=grid[n-1][i];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int point = grid[i][j];
                int ans= Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    ans=Math.min(ans, point + moveCost[point][k] + dp[i+1][k]);
                    dp[i][j]=ans;
                }
            }
        }

        int result=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            result = Math.min(result, dp[0][i]);
        }
        return result;
    }
}

//Space
//Time Complexity: O(N*N*M)
//Space Complexity: O(N*M)
class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length;
        int m = grid[0].length;

        int prev[] = new int[m];
        
        for (int i = 0; i < m; i++) {
            prev[i]=grid[n-1][i];
        }

        for (int i = n-2; i >= 0; i--) {
            int temp[] = new int[m];
            for (int j = 0; j < m; j++) {
                int point = grid[i][j];
                int ans= Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    ans=Math.min(ans, point + moveCost[point][k] + prev[k]);
                    temp[j]=ans;
                }
            }
            prev=temp;
        }

        int result=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            result = Math.min(result, prev[i]);
        }
        return result;
    }
}
