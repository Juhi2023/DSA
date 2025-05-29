import java.util.*;

class PalindromePartitioning2{

    public static boolean isPalindromic(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static int helper(String s, int index, int n, int dp[]){
        if(index==n){
            return 0;
        }

        if(dp[index]!=-1){
            return dp[index];
        }
        int minCost = Integer.MAX_VALUE;
        for(int i= index ; i<n; i++){
            if(isPalindromic(s, index, i)){
                int cost = 1+ helper(s, i+1, n, dp);
                minCost = Math.min(minCost, cost);
            }            
        }
        return dp[index]=minCost;
    }

    //Memoization
    //Time Complexity: O(N*2)
    //Space Complexity: O(N)
    public static int minCuts(String s){
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp, -1);
        return helper(s, 0, n, dp)-1;
    }

    //Tabulation
    //Time Complexity: O(N*2)
    //Space Complexity: O(N)
    public static int minCutsTab(String s){
        int n=s.length();
        int dp[]=new int[n+1];

        for(int i=n-1; i>=0; i--){
            int minCost = Integer.MAX_VALUE;
            for(int k= i ; k<n; k++){
                if(isPalindromic(s, i, k)){
                    int cost = 1+dp[k+1];
                    minCost = Math.min(minCost, cost);
                }    
            }
            dp[i]=minCost;        
        }
        return dp[0]-1;
    }

    public static void main(String[] args) {
        System.out.println(minCutsTab("aabb"));
    }
}