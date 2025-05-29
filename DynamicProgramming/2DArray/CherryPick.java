
import java.util.*;

class CherryPick {
    //Memoization
    // Time Complexity: O(N*M*M*9)
    // Space Complexity: O(N*M*M)
    static int maxChocoUtil(int i, int j1, int j2, int n, int[][] grid, int[][][] dp) {
        int i2 = i+j1-j2;

        if (i >= n || j2 >= n || j1 >= n || i2>=n || grid[i][j1]==-1 || grid[i2][j2]==-1)
            return Integer.MIN_VALUE;

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        if (i == n-1 && j2== n - 1)
            return grid[i][j1];


        int ans=0;
        if(i==i2 && j1==j2){
            ans=grid[i][j1];
        }else{
            ans=grid[i][j1] + grid[i2][j2];
        }

        int maxi = Integer.MIN_VALUE;
        int dir[][]={
            {1, 0, 0},
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 1}
        };
        for (int k = 0; k <4; k++) {
            maxi = Math.max(maxi, maxChocoUtil(i + dir[k][0], j1 + dir[k][1], j2 + dir[k][2], n, grid, dp));
        }
        return dp[i][j1][j2] = ans+maxi;
    }

    static int maximumChocolates(int n, int m, int[][] grid) {
        int dp[][][] = new int[n][m][m];

        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return maxChocoUtil(0, 0, 0, n, grid, dp);
    }
    

    public static void main(String args[]) {
        int matrix[][] = {{0,1,-1},{1,0,-1},{1,1,1}};
        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(maximumChocolates(n, m, matrix));
    }
}

