
import java.util.*;

class PartitionSetInto2SubsetsWithMinAbsoluteSumDiff{
    //Memoization
    // Time Complexity: O(N*k) O(N) + O(N)
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

    static int minSubsetSumDifference(int[] set, int n) {
        int total = 0;
        for(int i=0; i<n; i++){
            total+= set[i];
        }
        Boolean dp[][] = new Boolean[n][total + 1];
        for(int k=0; k<=total; k++){
            subsetSumToKUtil(set, n-1, k, dp);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<=total; i++){
            if (dp[n - 1][i]) 
                min = Math.min(Math.abs(i- (total-i)), min);        
        }
        return min;
    }

    //Tabulation
    // Time Complexity: O(N*k) O(N) + O(N)
    // Space Complexity: O(N*k)
    static int minSubsetSumDifferenceTab(int[] set, int n) {
        int total = 0;
        for(int i=0; i<n; i++){
            total+= set[i];
        }
        boolean dp[][] = new boolean[n][total + 1];
        
        // Base Condition
        for (int i = 0; i <n; i++) {
            dp[i][0] = true;
        }

        if(set[0]<=total){
            dp[0][set[0]]=true;
        }
        
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= total; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (set[ind] <= target) {
                    taken = dp[ind - 1][target - set[ind]];
                }
                
                dp[ind][target] = taken || notTaken;
            }
        }
        
        int min=Integer.MAX_VALUE;
        for(int i=0; i<=total; i++){
            if (dp[n - 1][i]) 
                min = Math.min(Math.abs(i- (total-i)), min);        
        }
        return min;
    }

    //Space Optimization
    // Time Complexity: O(N*k) O(N) + O(N)
    // Space Complexity: O(k)
    static int minSubsetSumDifferenceSO(int[] set, int n) {
        int total = 0;
        for(int i=0; i<n; i++){
            total+= set[i];
        }
        boolean prev[] = new boolean[total + 1];
        
        // Base Condition
        prev[0] = true;

        if(set[0]<=total){
            prev[set[0]]=true;
        }
        
        for (int ind = 1; ind < n; ind++) {
            boolean temp []= new boolean[total+1];
            temp[0]=true;
            for (int target = 1; target <=total; target++) {
                boolean notTaken = prev[target];
                boolean taken = false;
                if (set[ind] <= target) {
                    taken = prev[target - set[ind]];
                }
                
                temp[target] = taken || notTaken;
            }
            prev=temp;
        }
        
        int min=Integer.MAX_VALUE;
        for(int i=0; i<=total; i++){
            if (dp[n - 1][i]) 
                min = Math.min(Math.abs(i- (total-i)), min);        
        }
        return min;
    }

    public static void main(String args[]) {
        int set[] = {0,0,1};
        int n = set.length;

        System.out.println(minSubsetSumDifferenceSO(set, n));
    }
}

