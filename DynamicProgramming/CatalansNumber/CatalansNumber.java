import java.util.*;

class CatalansNumber{
    //Memoization
    //Time Complexity: O(N*N)
    //Space Complexity: O(N)
    public static int helper(int n, int [] dp){
        if(n==0|| n==1)
            return dp[n]=1;
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0; i<n; i++){
            ans+= (helper(i, dp) * helper(n-i-1, dp));
        }
        return dp[n]=ans;
    }

    public static int catalanNumber(int n){
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    //Tabulation
    //Time Complexity: O(N*N)
    //Space Complexity: O(N)
    public static int catalanNumberTab(int n){
        int dp[] = new int[n+1];
        dp[0]=dp[1]=1;
        for(int index=2; index<=n; index++ ){
            int ans=0;
            for(int i=0; i<index; i++){
                ans+= dp[i]* dp[index-i-1];
            }
            dp[index]=ans;
        }
        return dp[n];
    }

    public static void main(String args[]){
        System.out.println(catalanNumberTab(4));
    }
}