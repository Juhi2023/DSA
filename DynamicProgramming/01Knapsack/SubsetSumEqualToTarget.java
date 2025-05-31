
import java.util.*;

class SubsetSumEqualToTarget {
    //Memoization
    // Time Complexity: O(N*k)
    // Space Complexity: O(N*k)
    static boolean subsetSumToKUtil(int[] set, int ind, int K, Boolean[][] dp) {
        if (K == 0)
            return true;

        if (ind == 0)
            return set[0] == K;


        if (dp[ind][K] != null) {
            return dp[ind][K];
        }

        boolean notTaken = subsetSumToKUtil(set, ind - 1, K, dp);
        boolean taken = false;
        if (set[ind] <= K) {
            taken = subsetSumToKUtil(set, ind - 1, K - set[ind], dp);
        }

        dp[ind][K] = notTaken || taken;
        return dp[ind][K];
    }

    static boolean subsetSumToK(int[] set, int n, int K) {
        Boolean dp[][] = new Boolean[n][K + 1];
        return subsetSumToKUtil(set, n - 1, K, dp);
    }

    //Tabulation
    // Time Complexity: O(N*k)
    // Space Complexity: O(N*k)
    static boolean subsetSumToKTab(int[] set, int n, int K) {
        boolean dp[][] = new boolean[n][K + 1];
        
        // Base Condition
        for (int i = 0; i <n; i++) {
            dp[i][0] = true;
        }

        if(set[0]<=K){
            dp[0][set[0]]=true;
        }
        
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= K; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (set[ind] <= target) {
                    taken = dp[ind - 1][target - set[ind]];
                }
                
                dp[ind][target] = taken || notTaken;
            }
        }
        
        return dp[n - 1][K];
    }

    //Space Optimization
    // Time Complexity: O(N*k)
    // Space Complexity: O(k)
    static boolean subsetSumToKSO(int[] set, int n, int K) {
        boolean prev[] = new boolean[K + 1];
        
        // Base Condition
        prev[0] = true;

        if(set[0]<=K){
            prev[set[0]]=true;
        }
        
        for (int ind = 1; ind < n; ind++) {
            boolean temp []= new boolean[K+1];
            temp[0]=true;
            for (int target = 1; target <= K; target++) {
                boolean notTaken = prev[target];
                boolean taken = false;
                if (set[ind] <= target) {
                    taken = prev[target - set[ind]];
                }
                
                temp[target] = taken || notTaken;
            }
            prev=temp;
        }
        
        return prev[K];
    }

    public static void main(String args[]) {
        int set[] = {0,0,1};
        int K = 1;
        int n = set.length;

        System.out.println(subsetSumToKSO(set, n, K));
    }
}

