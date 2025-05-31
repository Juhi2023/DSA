import java.util.*;
class OnesAndZeros{
     //Memoization
    // Time Complexity: O(Len* N * M)
    // Space Complexity: O(Len* N * M)
    public static int helper(int[] ones, int[] zeros, int index, int m, int n, int[][][] dp) {
        if (index < 0) {
            return 0;
        }

        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }
        int notTake = helper(ones, zeros, index - 1, m, n, dp);

        int take = 0;
        if (m >= zeros[index] && n >= ones[index]) {
            take = 1 + helper(ones, zeros, index - 1, m - zeros[index], n - ones[index], dp);
        }

        return dp[index][m][n] = Math.max(take, notTake);
    }

    public static int getMaxLength(String[] strs, int m, int n) {
        int len = strs.length;
        int[] ones = new int[len];
        int[] zeros = new int[len];

        for (int i = 0; i < len; i++) {
            int oneCount = 0, zeroCount = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') zeroCount++;
                else oneCount++;
            }
            ones[i] = oneCount;
            zeros[i] = zeroCount;
        }

        int[][][] dp = new int[len][m + 1][n + 1];
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        return helper(ones, zeros, len - 1, m, n, dp);
    }

    //Tabulation
    // Time Complexity: O(Len* N * M)
    // Space Complexity: O(Len* N * M)
    public static int getMaxLengthTab(String[] strs, int m, int n) {
        int len = strs.length;
        int[] ones = new int[len];
        int[] zeros = new int[len];

        for (int i = 0; i < len; i++) {
            int oneCount = 0, zeroCount = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') zeroCount++;
                else oneCount++;
            }
            ones[i] = oneCount;
            zeros[i] = zeroCount;
        }

        int[][][] dp = new int[len+1][m + 1][n + 1];
        for(int i=1; i<=len; i++){
            for(int j=0; j<=m; j ++){
                for(int k=0; k<=n; k++){
                    int notTake = dp[i - 1][j][k];
                    int take = 0;
                    if (j >= zeros[i-1] && k >= ones[i-1]) {
                        take = 1 + dp[i - 1] [j - zeros[i-1]][k - ones[i-1]];
                    }

                   dp[i][j][k] = Math.max(take, notTake);
                }
            }
        }

        return dp[len][m][n];
    }

    //SO
    // Time Complexity: O(N * M)
    // Space Complexity: O(N * M)
    public static int getMaxLengthSO(String[] strs, int m, int n) {
        int len = strs.length;
        int[] ones = new int[len];
        int[] zeros = new int[len];

        for (int i = 0; i < len; i++) {
            int oneCount = 0, zeroCount = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') zeroCount++;
                else oneCount++;
            }
            ones[i] = oneCount;
            zeros[i] = zeroCount;
        }

        int[][] prev = new int[m + 1][n + 1];
        for(int i=1; i<=len; i++){
            int[][] temp = new int[m + 1][n + 1];

            for(int j=0; j<=m; j ++){
                for(int k=0; k<=n; k++){
                    int notTake = prev[j][k];
                    int take = 0;
                    if (j >= zeros[i-1] && k >= ones[i-1]) {
                        take = 1 + prev[j - zeros[i-1]][k - ones[i-1]];
                    }

                   temp[j][k] = Math.max(take, notTake);
                }
            }
            prev=temp;
        }

        return prev[m][n];
    }


    public static void main(String args[]){
        System.out.println(getMaxLengthSO(new String[]{"10","0001","111001","1","0"}, 5, 3));
    }
}