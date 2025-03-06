import java.util.*;
class ValidParenthesisString{

    //Recusrsion
    //Time Complexity: O(3^n)
    //Space Complexity: O(n)
    public static boolean isValid(String s, int cnt, int index){
        if(index==s.length())
            return cnt==0;
        
        if(cnt<0)
            return false;

        if(s.charAt(index)=='('){
            return isValid(s, cnt+1, index+1);
        }
        if(s.charAt(index)==')'){
            return isValid(s, cnt-1, index+1);
        }
        return isValid(s, cnt-1, index+1) || isValid(s, cnt+1, index+1) || isValid(s, cnt, index+1);
    }


    //Using DP (memoization)
    public static boolean isValidByDPMemoization(String s, int cnt, int index, Boolean memo [][]){
        if(index==s.length())
            return cnt==0;

        if(cnt<0)
            return false;

        if (memo[index][cnt] != null) 
            return memo[index][cnt];
        
        if(s.charAt(index)=='('){
            return memo[index][cnt] = isValidByDPMemoization(s, cnt+1, index+1, memo);
        }else if(s.charAt(index)==')'){
            return memo[index][cnt] = isValidByDPMemoization(s, cnt-1, index+1, memo);
        }else{
            if(isValidByDPMemoization(s, cnt-1, index+1, memo) || isValidByDPMemoization(s, cnt+1, index+1, memo) || isValidByDPMemoization(s, cnt, index+1, memo))
            return memo[index][cnt]=true;
        }
        return memo[index][cnt]=false;
    }

    //Using DP (tabulation)
    public static boolean isValidByDPTabulation(String s, int cnt, int index, Boolean memo [][]){
        int n = s.length();
        // DP table: dp[i][j] means whether the substring s[0:i] can be valid with j unmatched open parentheses
        boolean[][] dp = new boolean[n + 1][n + 1];

        dp[0][0] = true;

        // Iterate over each character in the string
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (s.charAt(i - 1) == '(') {
                    // If current char is '(', we need one more unmatched open parentheses
                    if (j > 0) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else if (s.charAt(i - 1) == ')') {
                    // If current char is ')', we need one less unmatched open parentheses (match with '(')
                    if (j < n) {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                } else {  // Current char is '*'
                    // '*' can act as '(', ')', or ''
                    if (j > 0) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 1];  // '*' as '('
                    }
                    if (j < n) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j + 1];  // '*' as ')'
                    }
                    dp[i][j] = dp[i][j] || dp[i - 1][j];  // '*' as ''
                }
            }
        }

        // The string is valid if there's no unmatched open parentheses left after processing all characters
        return dp[n][0];
    }

    //Using Greedy Approach
    public static boolean isValidByGreedy(String s){
        int n = s.length();
        int minRange=0;
        int maxRange=0;

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c=='('){
                minRange++;
                maxRange++;
            }else if(c==')'){
                minRange--;
                maxRange--;
            }else{
                minRange--;
                maxRange++;
            }

            if(minRange<0)
                minRange=0;
            if(maxRange<0)
                return false;
        }
        
        return minRange==0;
    }

    public static void main(String args[]){
        String s="(*)*)";

        // System.out.println(isValid(s, 0, 0));

        // int len = s.length();
        // Boolean[][] memo = new Boolean[len + 1][len + 1];
        // System.out.println(isValidByDPMemoization(s, 0, 0, memo));

        System.out.println(isValidByGreedy(s));
    }
}