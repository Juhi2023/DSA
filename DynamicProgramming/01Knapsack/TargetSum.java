
import java.util.*;

//If we are given the array as [a,b,c,d,e], we want to place ‘+’ or ‘-’ signs in front of every array element and then add it. 
// One example is : +a-b-c+d+e which can be written as (+a+d+e) + (-b-c).
//Therefore, we can say that S1=(+a+d+e) and S2=(-b-c) for this example.

class TargetSum{
    //Memoization
    // Time Complexity: O(N*k) + O(N)
    // Space Complexity: O(N*k)
      static int subsetSumToKUtil(int[] set, int ind, int K, int[][] dp) {

        if (ind == 0){
            if(K==0 && set[0]==0)
                return 2;
            if(K==0 || set[0]==K){
                return 1;
            }
            return 0;
        }
            


        if (dp[ind][K] != -1) {
            return dp[ind][K];
        }

        int notTaken = subsetSumToKUtil(set, ind - 1, K, dp);
        int taken = 0;
        if (set[ind] <= K) {
            taken = subsetSumToKUtil(set, ind - 1, K - set[ind], dp);
        }

        dp[ind][K] = notTaken + taken;
        return dp[ind][K];
    }

    static int targetSum(int[] set, int n, int K) {
        int total = 0;
        for(int i=0; i<n; i++){
            total+= set[i];
        }

        if((total+K)<0 || (total+K)%2==1)
            return 0;
        int sum=(total+K)/2;
        int dp[][] = new int[n][sum + 1];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        return subsetSumToKUtil(set, n-1, sum, dp);
    }

    //Tabulation
    // Time Complexity: O(N*k) + O(N)
    // Space Complexity: O(N*k)
    static int targetSumTab(int[] set, int n, int K) {
        int total = 0;
        for(int i=0; i<n; i++){
            total+= set[i];
        }

        if((total+K)<0 || (total+K)%2==1)
            return 0;
        int sum=(total+K)/2;
        int dp[][] = new int[n][sum + 1];
        
        // Base Condition
        dp[0][0] = set[0]==0 ? 2 : 1;

        if(set[0] !=0 && set[0]<=sum){
            dp[0][set[0]]=1;
        }
        
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= sum; target++) {
                int notTaken = dp[ind - 1][target];
                int taken = 0;
                if (set[ind] <= target) {
                    taken = dp[ind - 1][target - set[ind]];
                }
                
                dp[ind][target] = taken + notTaken;
            }
        }
        
        return dp[n-1][sum];
    }

    //Space Optimization
    // Time Complexity: O(N*k) + O(N)
    // Space Complexity: O(k)
    static int targetSumSO(int[] set, int n, int K) {
        int total = 0;
        for(int i=0; i<n; i++){
            total+= set[i];
        }

        if((total+K)<0 || (total+K)%2==1)
            return 0;
        int sum=(total+K)/2;
        int prev[] = new int[sum + 1];
        
        // Base Condition
        prev[0] = set[0]==0 ? 2 : 1;

        if(set[0] !=0 && set[0]<=sum){
            prev[set[0]]=1;
        }
        
        for (int ind = 1; ind < n; ind++) {
            int temp[] = new int[sum + 1];
            for (int target = 0; target <= sum; target++) {
                int notTaken = prev[target];
                int taken = 0;
                if (set[ind] <= target) {
                    taken = prev[target - set[ind]];
                }
                
                temp[target] = taken + notTaken;
            }
            prev=temp;
        }
        
        return prev[sum];
    }

    public static void main(String args[]) {
        int set[] = {0,0,1};
        int K = 1;
        int n = set.length;

        System.out.println(targetSumSO(set, n,K));
    }
}

