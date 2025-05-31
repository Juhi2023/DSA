import java.util.*;

class NumberOfLongestIncreasingSubsequences {
    //Another way of Tabultaion which will be used in printing
    //Time Complexity: O(N*N)
    //Space Complexity: O((N)
     static int cntLongestIncreasingSubsequence(int nums[], int n) {
         int dp[]=new int[n];
        Arrays.fill(dp,1);
        int cnt[]=new int[n];
        Arrays.fill(cnt,1);
    
        int ans = 1;
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                if(nums[prev_index]<nums[i] && dp[i]<dp[prev_index]+1){
                    dp[i] = dp[prev_index]+1;
                    cnt[i] = cnt[prev_index];
                }else if(nums[prev_index]<nums[i] && dp[i]== 1 + dp[prev_index]){
                    cnt[i] = cnt[i] + cnt[prev_index];
                }
            }
            ans=Math.max(ans, dp[i]);
        }

        int count=0;
        for(int i=0; i<=n-1; i++){
            if(ans==dp[i]){
                count+=cnt[i];
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 4, 7, 101, 18};
        int n = arr.length;
        System.out.println("The number of the longest increasing subsequence is " + cntLongestIncreasingSubsequence(arr, n));
    }
}