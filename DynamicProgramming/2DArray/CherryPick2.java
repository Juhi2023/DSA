
import java.util.*;

class CherryPick2 {
    //Memoization
    // Time Complexity: O(N*M*M*9)
    // Space Complexity: O(N*M*M)
    static int maxChocoUtil(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
        return (int) (Math.pow(-10, 9));

        if (i == n - 1) {
        if (j1 == j2)
            return grid[i][j1];
        else
            return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1)
        return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
        for (int dj = -1; dj <= 1; dj++) {
            int ans;
            if (j1 == j2)
            ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
            else
            ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
            maxi = Math.max(maxi, ans);
        }
        }
        return dp[i][j1][j2] = maxi;
    }

    static int maximumChocolates(int n, int m, int[][] grid) {
        int dp[][][] = new int[n][m][m];

        for (int row1[][] : dp) {
        for (int row2[] : row1) {
            Arrays.fill(row2, -1);
        }
        }

        return maxChocoUtil(0, 0, m - 1, n, m, grid, dp);
    }

    //Tabulation
    // Time Complexity: O(N*M*M*9)
    // Space Complexity: O(N*M*M)
    static int maximumChocolatesByTab(int n, int m, int[][] grid) {
        int dp[][][] = new int[n][m][m];
        for(int c1=0; c1<m; c1++){
            for(int c2=0; c2<m; c2++){
                if(c1==c2){
                    dp[n-1][c1][c2] = grid[n-1][c1];
                }else{
                    dp[n-1][c1][c2] = grid[n-1][c2] + grid[n-1][c1];
                }
            }
        }

        for(int r=n-2; r>=0; r--){
            for(int c1=0; c1<m; c1++){
                for(int c2=0; c2<m; c2++){
                    int maxi=Integer.MIN_VALUE;
                    for(int di=-1; di<=1; di++){
                        for(int dj=-1; dj<=1; dj++){
                            int ans=0;
                            if(c1==c2){
                                ans=grid[r][c1];
                            }else{
                                ans=grid[r][c1]+grid[r][c2];
                            }

                            if(c1+di<0 || c1+di>=m || c2+dj<0 || c2+dj>=m){
                                ans=Integer.MIN_VALUE;
                            }else{
                                ans+= dp[r+1][c1+di][c2+dj];
                            }
                            maxi = Math.max(maxi, ans);
                        }
                    }
                    dp[r][c1][c2]= maxi;
                }
            }
        }

        return dp[0][0][m-1];
    }

    //Tabulation
    // Time Complexity: O(N*M*M*9)
    // Space Complexity: O(M*M)
    static int maximumChocolatesBySO(int n, int m, int[][] grid) {
        int prev[][] = new int[m][m];
        for(int c1=0; c1<m; c1++){
            for(int c2=0; c2<m; c2++){
                if(c1==c2){
                    prev[c1][c2] = grid[n-1][c1];
                }else{
                    prev[c1][c2] = grid[n-1][c2] + grid[n-1][c1];
                }
            }
        }

        for(int r=n-2; r>=0; r--){
            int temp[][] = new int[m][m];
            for(int c1=0; c1<m; c1++){
                for(int c2=0; c2<m; c2++){
                    int maxi=Integer.MIN_VALUE;
                    for(int di=-1; di<=1; di++){
                        for(int dj=-1; dj<=1; dj++){
                            int ans=0;
                            if(c1==c2){
                                ans=grid[r][c1];
                            }else{
                                ans=grid[r][c1]+grid[r][c2];
                            }

                            if(c1+di<0 || c1+di>=m || c2+dj<0 || c2+dj>=m){
                                ans=Integer.MIN_VALUE;
                            }else{
                                ans+= prev[c1+di][c2+dj];
                            }
                            maxi = Math.max(maxi, ans);
                        }
                    }
                    temp[c1][c2]= maxi;
                }
            }
            prev=temp;
        }

        return prev[0][m-1];
    }

    

    public static void main(String args[]) {
        int matrix[][] = {{2, 3, 1, 2},
                        {3, 4, 2, 2},
                        {5, 6, 3, 5}};
        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(maximumChocolatesByTab(n, m, matrix));
    }
}

