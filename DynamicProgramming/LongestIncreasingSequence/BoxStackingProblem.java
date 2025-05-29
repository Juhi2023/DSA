import java.util.*;

class BoxStackingProblem {
    //Memoization
    //Time Complexity: O(N*N) + N*3 * log(N*3) + N * log(N)
    //Space Complexity: O((N*N)
    static int helper(int cuboids[][], int n, int ind, int prev_index, int[][] dp) {
        if (ind == n) {
            return 0;
        }

        if (dp[ind][prev_index + 1] != -1) {
            return dp[ind][prev_index + 1];
        }

        int notTake = 0 + helper(cuboids, n, ind + 1, prev_index, dp);

        int take = 0;
        if (prev_index == -1 || (cuboids[ind][0] >= cuboids[prev_index][0] && cuboids[ind][1] >= cuboids[prev_index][1] && cuboids[ind][2] >= cuboids[prev_index][2])) {
            take = cuboids[ind][2] + helper(cuboids, n, ind + 1, ind, dp);
        }

        dp[ind][prev_index + 1] = Math.max(notTake, take);
        return dp[ind][prev_index + 1];
    }

    static int maxHeight(int cuboids[][], int n) {
        int dp[][] = new int[n][n];

        for(int x[]: cuboids){
            Arrays.sort(x);
        }

        Arrays.sort(cuboids, (a, b)->{
            if(a[0]==b[0]){
                if(a[1]==b[1]){
                    return a[2]-b[2];
                }
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return helper(cuboids, n, 0, -1, dp);
    }

    //Another way of Tabultaion which will be used in printing
    //Time Complexity: O(N*N) + N*3 * log(N*3) + N * log(N)
    //Space Complexity: O((N)
     static int maxHeightTab(int cuboids[][], int n) {
        int dp[]=new int[n];
        
        for(int x[]: cuboids){
            Arrays.sort(x);
        }

        Arrays.sort(cuboids, (a, b)->{
            if(a[0]==b[0]){
                if(a[1]==b[1]){
                    return a[2]-b[2];
                }
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
    
        for(int i=0; i<n; i++){
            dp[i]=cuboids[i][2];
        }
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                
                if(cuboids[i][0] >= cuboids[prev_index][0] && cuboids[i][1] >= cuboids[prev_index][1] && cuboids[i][2] >= cuboids[prev_index][2]){
                    dp[i] = Math.max(dp[i], cuboids[i][2] + dp[prev_index]);
                }
            }
        }
        int ans = -1;
    
        for(int i=0; i<=n-1; i++){
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }



    public static void main(String args[]) {
        int cuboids[][] = {{50,45,20},{95,37,53},{45,23,12}};
        int n = cuboids.length;
        System.out.println("The max height is " + maxHeightTab(cuboids, n));
    }
}