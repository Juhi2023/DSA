import java.util.*;

class PrintLongestIncreasingSequence {
    //Memoization
    //Time Complexity: O(N*N)
    //Space Complexity: O((N*N)
    static int getAns(int arr[], int n, int ind, int prev_index, int[][] dp) {
        if (ind == n) {
            return 0;
        }

        if (dp[ind][prev_index + 1] != -1) {
            return dp[ind][prev_index + 1];
        }

        int notTake = 0 + getAns(arr, n, ind + 1, prev_index, dp);

        int take = 0;
        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns(arr, n, ind + 1, ind, dp);
        }

        dp[ind][prev_index + 1] = Math.max(notTake, take);
        return dp[ind][prev_index + 1];
    }
    static int longestIncreasingSubsequence(int arr[], int n) {
        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return getAns(arr, n, 0, -1, dp);
    }

    //Tabulation
    //Time Complexity: O(N*N)
    //Space Complexity: O((N*N)
    static int longestIncreasingSubsequenceTab(int arr[], int n) {
        int dp[][] = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int pi=i-1; pi>=-1; pi--){
                int notTake = dp[i+1][pi+1];
                int take =  0;
                if(pi==-1 || (arr[i]>arr[pi])){
                    take = 1+ dp[i+1][i+1];
                }
                dp[i][pi+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    //SO
    //Time Complexity: O(N*N)
    //Space Complexity: O((2N)
     static int longestIncreasingSubsequenceSO(int arr[], int n) {
        int prev[] = new int[n+1];
        for(int i=n-1; i>=0; i--){
            int temp[] = new int[n+1];
            for(int pi=i-1; pi>=-1; pi--){
                int notTake = prev[pi+1];
                int take =  0;
                if(pi==-1 || (arr[i]>arr[pi])){
                    take = 1+ prev[i+1];
                }
                temp[pi+1] = Math.max(take, notTake);
            }
            prev=temp;
      
        }
        return prev[0];
    }

    //Another way of Tabultaion which will be used in printing
    //Time Complexity: O(N*N)
    //Space Complexity: O((N)
     static int longestIncreasingSubsequenceTab2(int arr[], int n) {
        int dp[]=new int[n];
        Arrays.fill(dp,1);
    
    
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                
                if(arr[prev_index]<arr[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
                }
            }
        }
        int ans = -1;
    
        for(int i=0; i<=n-1; i++){
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }


    //Printing LIS
    //Time Complexity: O(N*N)
    //Space Complexity: O((N)
     static int longestIncreasingSubsequenceTabPrint(int arr[], int n) {
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int hash[]=new int[n];

    
        for(int i=0; i<=n-1; i++){
            hash[i]=i;
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                
                if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
                    dp[i] = 1 + dp[prev_index];
                    hash[i]=prev_index;
                }
            }
        }
        int ans = -1;
        int lastIndex = -1;
    
        for(int i=0; i<=n-1; i++){
            if(ans<dp[i]){
                ans=dp[i];
                lastIndex=i;
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            temp.add(0, arr[lastIndex]);
        }
        // Collections.reverse(temp);
        System.out.println(temp);
        
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;
        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequenceTabPrint(arr, n));
    }
}