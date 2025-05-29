import java.util.*;

class EvaluateBooleanExpressionToTrue {
    //Mmoization
    //Time Complexity: O(N*N*2*N)
    //Space Complexity: O((N*N*2)
    static final int MOD = 1000000007;
    static int ways(String s, int i, int j, int isTrue, int dp[][][]) {
        if (i > j)
            return 0;

        if (dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];

        if (i == j) {
            if (isTrue == 1)
                return dp[i][j][isTrue]=s.charAt(i) == 'T' ? 1 : 0;
            else
                return dp[i][j][isTrue]=s.charAt(i) == 'F' ? 1 : 0;
        }

        int maxWays = 0;

        for (int k = i + 1; k < j; k += 2) {
            int lT = ways(s, i, k - 1, 1, dp);
            int lF = ways(s, i, k - 1, 0, dp);
            int rT = ways(s, k + 1, j, 1, dp);
            int rF = ways(s, k + 1, j, 0, dp);

            char operator = s.charAt(k);

            if (operator == '&') {
                if (isTrue == 1)
                    maxWays = (maxWays + (lT * rT) % MOD) % MOD;
                else
                    maxWays = (maxWays + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
            } else if (operator == '|') {
                if (isTrue == 1)
                    maxWays = (maxWays + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;
                else
                    maxWays = (maxWays + (lF * rF) % MOD) % MOD;
            } else if (operator == '^') {
                if (isTrue == 1)
                    maxWays = (maxWays + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;
                else
                    maxWays = (maxWays + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
            }
        }

        return dp[i][j][isTrue] = maxWays;
    }

    static int countWays(String s) {
        int n = s.length();
        int dp[][][] = new int[n][n][2];
        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }
        return ways(s, 0, n - 1, 1, dp);
    }

    //Tabulation
    //Time Complexity: O(N*N*2*N)
    //Space Complexity: O((N*N*2)
    static int countWaysTab(String s) {
        int n = s.length();
        int dp[][][] = new int[n][n][2];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    if(i==j){
                        if (isTrue == 1) 
                            dp[i][j][isTrue] = s.charAt(i) == 'T' ? 1 : 0;
                        else 
                            dp[i][j][isTrue] = s.charAt(i) == 'F' ? 1 : 0;
                        continue;
                    }
                    int maxWays = 0;

                    for(int k=i+1; k<j; k+=2){
                        char operator = s.charAt(k);
                        int lT = dp[i][k - 1][1];
                        int lF = dp[i][k - 1][0];
                        int rT = dp[k + 1][j][1];
                        int rF = dp[k + 1][j][0];
                        if (operator == '&') {
                            if (isTrue == 1)
                                maxWays = (maxWays + (lT * rT) % MOD) % MOD;
                            else
                                maxWays = (maxWays + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
                        } else if (operator == '|') {
                            if (isTrue == 1)
                                maxWays = (maxWays + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;
                            else
                                maxWays = (maxWays + (lF * rF) % MOD) % MOD;
                        } else if (operator == '^') {
                            if (isTrue == 1)
                                maxWays = (maxWays + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;
                            else
                                maxWays = (maxWays + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
                        }
                    }
                    dp[i][j][isTrue] = maxWays;
                }
            }
        }
        
        return dp[0][n-1][1];
    }

    public static void main(String args[]) {
        System.out.println(countWaysTab("T|T&F^T"));
    }
}