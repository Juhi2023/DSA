
import java.util.*;

class RodCutting {
    //Memoization
    // Time Complexity: O(N*N)
    // Space Complexity: O(N*N)
    static int solve(int[] price, int ind, int l, int dp[][]) {
        if(ind==0){
            return 0;
        }
        if(dp[ind][l]!=-1)
            return dp[ind][l];
        
        int notTaken = solve(price, ind-1, l, dp);
        int taken=0;
        if(ind<=l){
            taken = price[ind-1] + solve(price, ind, l-ind, dp);
        }
        return dp[ind][l] = Math.max(notTaken, taken);
    }

    static int rodCutting(int[] price) {
        int n=price.length;
        int dp[][]= new int[n+1][n+1];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        return solve(price, n, n, dp);
    }

    //Tabulation
    // Time Complexity: O(N*N
    // Space Complexity: O(N*N

    //Space Optimization
    // Time Complexity: O(N*N
    // Space Complexity: O(N

    public static void main(String args[]) {
        int coins[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rodCutting(coins));
    }
}

