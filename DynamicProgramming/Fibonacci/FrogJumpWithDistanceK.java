//There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
import java.util.*;

class FrogJumpWithDistanceK{
    //Recursion
    // Time Complexity: O(2^N*K)
    // Space Complexity: O(N)
    public static int helper(int heights[], int n, int k) {
        if(n==0)
            return 0;
        int minEnergy = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(n-i>=0){
                int jump = helper(heights,n-i, k) + Math.abs(heights[n]-heights[n-i]);
                minEnergy = Math.min(minEnergy, jump);
            }
        }
        return minEnergy;
    }

    public static int getMinEnergy(int heights[]){
        return helper(heights,heights.length-1, 2);
    }

    //Memoization
    // Time Complexity: O(N*k)
    // Space Complexity: O(N)
    public static int helper(int heights[], int n, int dp[], int k) {
        if(n==0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int minEnergy = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(n-i>=0){
                dp[n] = helper(heights,n-i, k) + Math.abs(heights[n]-heights[n-i]);
                minEnergy = Math.min(minEnergy, jump);
            }
        }
        return dp[n] = minEnergy;
    }

    public static int getMinEnergyByMemo(int heights[]){
        int n = heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(heights, n-1, dp, 2);
    }

    //Tabulation
    // Time Complexity: O(N*k)
    // Space Complexity: O(N)
    public static int getMinEnergyByTab(int heights[]){
        int n =heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        
        dp[0] = 0;
        dp[1] = Math.abs(heights[1]-heights[0]);
        
        for(int i=2; i<n; i++){
            int mmSteps = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-jk>=0){
                    int jump = Math.abs(heights[i-j]-heights[i]) + dp[i-j];
                    minEnergy= Math.min(minEnergy, jump);
                }
                dp[i]=mmSteps;
            }
        }
        return dp[n - 1];
    }

    //Space Optimization
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int getMinEnergyBySO(int heights[]){
        int n =heights.length;
        
        int prev1 = 0;
        int prev2 = Math.abs(heights[1]-heights[0]);
        
        for(int i=2; i<n; i++){
            int jump1 = Math.abs(heights[i-1]-heights[i]) + prev2;
            int jump2 = Math.abs(heights[i-2]-heights[i]) + prev1;
            int curr= Math.min(jump1, jump2);
            prev1=prev2;
            prev2=curr;
        }
        return prev2;
    }

    public static void main(String args[]){
        System.out.println(getMinEnergyByTab(new int[]{30, 10, 60 , 10 , 60 , 50}));
    }
}