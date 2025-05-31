import java.util.*;
//https://www.youtube.com/watch?v=UvksR0hR9nA

class EggDropping{
    //Memoization
    //Time Complexity: O(E*F*F)
    //Space Complexity: O(E*F)
    public static int helper(int eggs, int floors, int dp[][]){
        if(floors==0 || floors==1)
            return floors;
        if(eggs==1)
            return floors;
        if(dp[eggs][floors]!=-1){
            return dp[eggs][floors];
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=floors; i++){
            int breaked = 1 + helper(eggs-1, i-1, dp);
            int notBreaked = 1 + helper(eggs, floors-i, dp);
            min = Math.min(min, Math.max(breaked, notBreaked));
        }
        return dp[eggs][floors]=min;
    }

    public static int getMoves(int eggs, int floors){
        int dp[][]=new int [eggs+1][floors+1];
        for(int x[]: dp){
            Arrays.fill(x, -1);
        }
        return helper(eggs, floors, dp);
    }

    //Tabulation
    //Time Complexity: O(E*F*F)
    //Space Complexity: O(E*F)
    public static int getMovesTab(int eggs, int floors){
        int dp[][]=new int [eggs+1][floors+1];
        for(int e=1; e<=eggs; e++){
            dp[e][0] = 0;
            dp[e][1] = 1;
        }
        for(int f=1; f<=floors; f++){
            dp[1][f] = f;
        }

        for(int e=2; e<=eggs; e++){
            for(int f=2; f<=floors; f++){
                int min = Integer.MAX_VALUE;
                for(int i=1; i<=f; i++){
                    int breaked = 1 + dp[e-1][i-1];
                    int notBreaked = 1 + dp[e][f-i];
                    min = Math.min(min, Math.max(breaked, notBreaked));
                }
                dp[e][f]=min;
            }
        }
        
        return dp[eggs][floors];
    }

    //SO
    //Time Complexity: O(E*F*F)
    //Space Complexity: O(F)
    public static int getMovesSO(int eggs, int floors) {
        int prev[]=new int [floors+1];
        
        for(int f=1; f<=floors; f++){
            prev[f] = f;
        }

        for(int e=2; e<=eggs; e++){
            int temp[]=new int [floors+1];
            for(int f=1; f<=floors; f++){
                int min = Integer.MAX_VALUE;
                for(int i=1; i<=f; i++){
                    int breaked = 1 + prev[i-1];
                    int notBreaked = 1 + temp[f-i];
                    min = Math.min(min, Math.max(breaked, notBreaked));
                }
                temp[f]=min;
            }
            prev=temp;
        }
        
        return prev[floors];
    }

    //Optimized Tabulation
    //Instead of checking min no of moves to solve for k floors
    //check how many floors we can check with given number of moves and eggs
    //here dp[i][j] represents min number of floors we can test with n j eggs ans i moves
    //Recurrance relation; dp[m][e] = 1+ dp[m-1][e-1] + dp[m-1][e]
    //Time Complexity: O(E*F*F)
    //Space Complexity: O(E*F)
    
    public static int getMovesOptimizedTab(int eggs, int floors){
        int[][] dp = new int[floors + 1][eggs + 1];

        int moves = 0;
        while (dp[moves][eggs] < floors) {
            moves++;
            for (int e = 1; e <= eggs; e++) {
                dp[moves][e] = dp[moves - 1][e - 1] + dp[moves - 1][e] + 1;
            }
        }

        return moves;
    }

    public static void main(String args[]){
        System.out.println(getMovesSO(2, 10));
    }
}