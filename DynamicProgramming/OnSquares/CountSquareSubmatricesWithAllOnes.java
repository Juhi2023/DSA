import java.util.*;

public class CountSquareSubmatricesWithAllOnes {
    //Memoization
    //Time Complexity: O(N*M)
    //Space Complexity: O(N*M)
    static int solve(int[][] matrix, int m, int n, int i, int j, int dp[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 0) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int right = solve(matrix, m, n, i, j + 1, dp);
        int bottom = solve(matrix, m, n, i + 1, j, dp);
        int bottomRight = solve(matrix, m, n, i + 1, j + 1, dp);

        return dp[i][j] = 1 + Math.min(Math.min(right, bottom), bottomRight);
    }

    static int countSquareMatrices(int [][]matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int [n+1][m+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        int sum = 0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                sum += solve(matrix, n, m, i, j, dp);
            }
        }
        return sum;
    }

    //Tabulation
    //Time Complexity: O(N*M)
    //Space Complexity: O(N*M)
    static int countSquareMatricesTab(int [][]matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int [n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(matrix[i-1][j-1]==0){
                    continue;
                }
                dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        int sum = 0;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countSquareMatrices(new int[][]{{1, 0, 1},{1, 1, 0},{1, 1, 0}}));
    }
}