import java.util.*;

class HouseRobber{
    //Recursion
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)
    public static int helper(int ind, int money[]) {
        if (ind < 0) 
            return 0;
        int pick = money[ind] + helper(ind - 2, money);
        int nonPick = helper(ind - 1, money);
        return Math.max(pick, nonPick);
    }

    public static int getHighestMoney(int money[]){
        return helper(money.length-1, money);
    }

    //Memoization
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int helper(int money[], int ind, int dp[]) {
        if (ind < 0) 
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int pick = money[ind] + helper( money,ind - 2, dp);
        int nonPick = helper(money, ind - 1, dp);
        return dp[ind] = Math.max(pick, nonPick);
    }

    public static int getHighestMoneyByMemo(int money[]){
        int n = money.length;
        int dp[] = new int[n];
        moneyays.fill(dp, -1);
        return helper(money, n-1, dp);
    }

    //Tabulation
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int getHighestMoneyByTab(int money[]){
        int n =money.length;
        int dp[] = new int[n];
        moneyays.fill(dp, -1);
        
        dp[0] = Math.max(0, money[0]);
        
        for(int i=1; i<n; i++){
            int pick = money[i];
            if(i>1)
                pick+=dp[i-2];
            int nonPick = dp[i-1];
            dp[i]= Math.max(pick, nonPick);
        }
        return dp[n - 1];
    }

    //Space Optimization
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int getHighestMoneyBySO(int money[]){
        int n =money.length;
        int prev1=0;
        int prev2 = Math.max(0, money[0]);
        
        for(int i=1; i<n; i++){
            int pick = money[i];
            pick+=prev1;
            int nonPick = prev2;

            prev1 = prev2;
            prev2= Math.max(pick, nonPick);
        }
        return prev2;
    }

    public static void main(String args[]){
        System.out.println(getHighestMoneyBySO(new int[]{2, 1, 4, 9}));
    }
}