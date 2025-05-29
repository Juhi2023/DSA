import java.util.*;

class DecodeWays{
    //Recursion
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)
    public static int helper(String s, int i){
        if(i==s.length())
            return 1;

        if(s.charAt(i)=='0')
            return 0;

        int ans=0;
        ans+= helper(s, i+1);  
        if(i+1<s.length()){
            int a = Integer.parseInt(s.substring(i, i+2));
            if(a<=26)
                ans+= helper(s, i+2);
        }
        return ans;
    }

    public static int getDecodeWays(String s){
        if(s.length()==0)
            return 0;
        return helper(s, 0);
    }

    //Memoization
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int helper(String s, int i, int dp[]){
        if(i==s.length())
            return 1;

        if(dp[i]!= -1)
            return dp[i];

        if(s.charAt(i)=='0')
            return 0;

        int ans=0;
        ans+= helper(s, i+1, dp);  
        if(i+1<s.length()){
            int a = Integer.parseInt(s.substring(i, i+2));
            if(a<=26)
                ans+= helper(s, i+2, dp);
        }
        return dp[i]=ans;
    }

    public static int getDecodeWaysMemo(String s) {
        int dp[] =new int[s.length()];
        Arrays.fill(dp, -1);
        if(s.length()==0)
            return 0;
        return helper(s, 0, dp);
    }

    //Tabulation
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int getDecodeWaysTab(String s) {
        if(s.length()==0 || s.charAt(0) == '0')
            return 0;
        int n = s.length();
        int dp[] =new int[n];
        Arrays.fill(dp, 0);
        dp[0]=1;   //----denoting empty string
        dp[1]=1   //----denoting first element
        for(int i=2; i<=n; i++){
            if(s.charAt(i-1)>='1' && s.charAt(i-1)<='9'){
                dp[i] += dp[i-1];
            }
            int num = s.substring(i-2, i);
            if(num>=10 && num<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String args[]){
        System.out.println(getDecodeWaysMemo("226"));
    }
}