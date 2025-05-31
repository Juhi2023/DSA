//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

//What dp[left][right] Represents:
// dp[left][right] stores the minimum cost to cut the sub-stick that lies between cuts[left] and cuts[right].
// More precisely, it refers to the minimum cost of making all cuts from cuts[left] to cuts[right] (inclusive) within the current segment of the stick defined by start_stick and end_stick.


import java.util.*;

class MinimumCostToCutAStick {
    //Memoization
    // Time Complexity: O(N^3)
    // Space Complexity: O(N^2)

    static int helper(int[] cuts, int left, int right, int dp[][]) {
        if (left > right) return 0;

        if (dp[left][right] != -1) return dp[left][right];

        int cost = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            int left_cost = helper( cuts, left, i - 1, dp);
            int right_cost = helper(cuts, i + 1, right, dp);
            int curr_cost = cuts[right+1]-cuts[left-1] + left_cost + right_cost;
            cost = Math.min(cost, curr_cost);
        }

        return dp[left][right] = cost;
    }

    static int minCost(int cuts[], int n) {
        int len = cuts.length;
        Arrays.sort(cuts);
        int newCuts[] = new int [len+2];
        newCuts[0]=0;
        for(int i=0; i<len; i++){
            newCuts[i+1]=cuts[i];
        }
        newCuts[len+1] = n;

        int dp[][]=new int[len+2][len+2];
        for(int x[]: dp){
            Arrays.fill(x,-1);
        }
        return helper(newCuts, 1, len, dp);
    }

    //Tabulation
    //Time Complexity: O(N*N*N)
    //Space Complexity: O((N*N)
    static int minCostTab(int cuts[], int n) {
        int len = cuts.length;
        Arrays.sort(cuts);
        int newCuts[] = new int [len+2];
        newCuts[0]=0;
        for(int i=0; i<len; i++){
            newCuts[i+1]=cuts[i];
        }
        newCuts[len+1] = n;

        int dp[][]=new int[len+2][len+2];
        for(int i=len; i>=1; i--){
            for(int j=i; j<=len; j++){
                int cost = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    int left_cost = dp[i][k-1];
                    int right_cost = dp[k + 1][j];
                    int curr_cost = newCuts[j+1]-newCuts[i-1] + left_cost + right_cost;
                    cost = Math.min(cost, curr_cost);
                    dp[i][j]= cost;
                }
            }
        }
        
        return dp[1][len];
    }

    public static void main(String args[]) {
        int arr[] = {3, 5, 1, 4 };
        System.out.println(minCostTab(arr, 7));
    }
}