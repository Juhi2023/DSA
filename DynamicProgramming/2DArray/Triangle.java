import java.util.*;

class Triangle {
    //Memoization
    // Time Complexity: O(N*N)
    // Space Complexity: O(N*N)
    public static int helper(int[][] triangle, int dp[][], int n, int x, int y) {
        if(dp[x][y]!=-1){
            return dp[x][y];
        }

        if(x==n-1)
            return dp[x][y]=triangle[x][y];

        int down =helper(triangle, dp, n, x+1, y);
        int diagonalRight =helper(triangle, dp, n, x+1, y+1);

        return dp[x][y] = triangle[x][y] + Math.min(down, diagonalRight);
    }

    public static int minPathSum(int[][] triangle, int n) {
        int dp[][]=new int[n][n];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        return helper(triangle, dp, n, 0, 0);
    }
    //Tabulation
    // Time Complexity: O(N*N)
    // Space Complexity: O(N*N)
    public static int minPathSumTab(int[][] triangle, int n) {
        int dp[][]=new int[n][n];
        for(int x[]: dp){
            Arrays.fill(x, 0);
        }
        for(int i=0; i<n; i++){
            dp[n-1][i] = triangle[n-1][i];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[i][j] = triangle[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }

    //Space Optimization
    // Time Complexity: O(N*N)
    // Space Complexity: O(N)
    public static int minPathSumSO(int[][] triangle, int n) {
        int prev[]=new int[n];
        for(int i=0; i<n; i++){
            prev[i] = triangle[n-1][i];
        }

        for(int i=n-2; i>=0; i--){
            int temp[] = new int[i+1];
            for(int j=0; j<=i; j++){
                temp[j] = triangle[i][j] + Math.min(prev[j], prev[j+1]);
            }
            prev=temp;
        }

        return prev[0];
    }

    public static void main(String args[]) {
        int triangle[][] = {{1},
                            {2, 3},
                            {3, 6, 7},
                            {8, 9, 6, 10}};

        int n = triangle.length;
        System.out.println(minPathSumSO(triangle, n)); 
    }
}

