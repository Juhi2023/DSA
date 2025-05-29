
import java.util.*;

class UnboundedKnapsack {
    //Memoization
    // Time Complexity: O(N*W)
    // Space Complexity: O(N*W)
    static int unboundedKnapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        if (ind == 0) {
            return (int)(W/wt[0])*val[0];
        }

        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int notTaken = 0 + unboundedKnapsackUtil(wt, val, ind - 1, W, dp);
        int taken = (int) Math.pow(10, 9);;
        if (wt[ind] <= W) {
            taken = val[ind] + unboundedKnapsackUtil(wt, val, ind, W - wt[ind], dp);
        }

        dp[ind][W] = Math.max(notTaken, taken);
        return dp[ind][W];
    }

    static int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int dp[][] = new int[n][W + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return unboundedKnapsackUtil(wt, val, n - 1, W, dp);
    }

    //Tabulation
    // Time Complexity: O(N*W)
    // Space Complexity: O(N*W)
    static int unboundedKnapsackTab(int[] wt, int[] val, int n, int W) {
        int dp[][] = new int[n][W + 1];
        
        // Base Condition
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = ((int) i / wt[0]) * val[0];
        }

        
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                int notTaken = dp[ind - 1][cap];
                int taken = (int) Math.pow(10, 9);;
                if (wt[ind] <= cap) {
                    taken = val[ind] + dp[ind][cap - wt[ind]];
                }
                
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }
        
        return dp[n - 1][W];
    }

    //Space Optimization
    // Time Complexity: O(N*W)
    // Space Complexity: O(W)
    static int unboundedKnapsackSO(int[] wt, int[] val, int n, int W) {
        int prev[] = new int[W + 1];
        for (int i = wt[0]; i <= W; i++) {
            prev[i] = ((int) i / wt[0]) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            int temp[]=new int[W+1];
            for (int cap = 0; cap <= W; cap++) {
                int notTaken = prev[cap];
                int taken = (int) Math.pow(10, 9);;
                if (wt[ind] <= cap) {
                    taken = val[ind] + temp[cap - wt[ind]];
                }
                
                temp[cap] = Math.max(notTaken, taken);
            }
            prev=temp;
        }
        return prev[W];
    }

    public static void main(String args[]) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        System.out.println(unboundedKnapsack(wt, val, n, W));
    }
}

