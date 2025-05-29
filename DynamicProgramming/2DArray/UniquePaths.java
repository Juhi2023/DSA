import java.util.*;

class UniquePaths {
    //Memoization
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public static int helper(int m, int n, int dp[][]) {
        if(n <0 || m<0)
            return 0;

        if(dp[m][n]!=-1)
            return dp[m][n];

        if(n==0 && m==0)
            return dp[0][0]= 1;

        int w1 = helper(m-1, n, dp);
        int w2 = helper(m, n-1, dp);

        return dp[m][n]=w1+w2;
    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        helper(m-1, n-1, dp);
        return dp[m-1][n-1];
    }
    //Tabulation
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public static int uniquePathsTab(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        dp[0][0]=1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int up = 0;
                int left = 0;

                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    //Space Optimization
    // Time Complexity: O(N*M)
    // Space Complexity: O(N)
    public static int uniquePathsSO(int m, int n) {
        int prevTop[] = new int[n];
        Arrays.fill(prevTop, 0);

        for (int i = 0; i < m; i++) {
            int temp[]= new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[0]=1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (i > 0)
                    up = prevTop[j];
                if (j > 0)
                    left = temp[j - 1];

                temp[j] = up + left;
            }
            prevTop=temp;
        }

        return prevTop[n - 1];
    }

    public static void main(String args[]) {

        System.out.println(uniquePathsSO(3, 7)); 
    }
}

