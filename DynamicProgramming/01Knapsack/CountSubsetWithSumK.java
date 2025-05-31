
import java.util.*;

class CountSubsetWithSumK {
    //Memoization
    // Time Complexity: O(N*k)
    // Space Complexity: O(N*k)
    static int countSubsetSumToKUtil(int[] set, int ind, int K, int[][] dp) {
        if (K == 0)
            return 1;

        if (ind == 0)
            return set[0] == K ? 1: 0;


        if (dp[ind][K] != -1) {
            return dp[ind][K];
        }

        int notTaken = countSubsetSumToKUtil(set, ind - 1, K, dp);
        int taken = 0;
        if (set[ind] <= K) {
            taken = countSubsetSumToKUtil(set, ind - 1, K - set[ind], dp);
        }

        dp[ind][K] = notTaken + taken;
        return dp[ind][K];
    }

    static int countSubsetSumToK(int[] set, int n, int K) {
        int dp[][] = new int[n][K + 1];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        return countSubsetSumToKUtil(set, n - 1, K, dp);
    }

    //Tabulation
    // Time Complexity: O(N*k)
    // Space Complexity: O(N*k)
    static int countSubsetSumToKTab(int[] set, int n, int K) {
        int dp[][] = new int[n][K + 1];
        
        // Base Condition
        for (int i = 0; i <n; i++) {
            dp[i][0] = 1;
        }

        if(set[0]<=K){
            dp[0][set[0]]=1;
        }
        
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= K; target++) {
                int notTaken = dp[ind - 1][target];
                int taken = 0;
                if (set[ind] <= target) {
                    taken = dp[ind - 1][target - set[ind]];
                }
                
                dp[ind][target] = taken + notTaken;
            }
        }
        
        return dp[n - 1][K];
    }

    //Space Optimization
    // Time Complexity: O(N*k)
    // Space Complexity: O(k)
    static int countSubsetSumToKSO(int[] set, int n, int K) {
        int prev[] = new int[K + 1];
        
        // Base Condition
        prev[0] = 1;

        if(set[0]<=K){
            prev[set[0]]=1;
        }
        
        for (int ind = 1; ind < n; ind++) {
            int temp []= new int[K+1];
            temp[0]=1;
            for (int target = 1; target <= K; target++) {
                int notTaken = prev[target];
                int taken = 0;
                if (set[ind] <= target) {
                    taken = prev[target - set[ind]];
                }
                
                temp[target] = taken + notTaken;
            }
            prev=temp;
        }
        
        return prev[K];
    }

    public static void main(String args[]) {
        int set[] = {0,0,1};  //4
        int K = 1;
        int n = set.length;

        System.out.println(countSubsetSumToKTab(set, n, K));
    }
}

