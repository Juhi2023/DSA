import java.util.*;

class LongestBitonicSubsequence {
    //Alternate tabulation approch as used in Print LIS
    //Time Complexity: O(N*N)
    //Space Complexity: O(N)
    
    static int largestBitonic(int nums[], int n) {
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for(int i=0; i<n; i++){
            for(int prev=0; prev<=i-1; prev++){
                if(nums[i]>nums[prev] && dp1[i]<1+dp1[prev]){
                    dp1[i]=1+dp1[prev];
                }
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int prev=n-1; prev>i; prev--){
                if(nums[i]>nums[prev] && dp2[i]<1+dp2[prev]){
                    dp2[i]=1+dp2[prev];
                }
            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            if(dp1[i]==1 || dp2[i]==1)
                continue;
            ans = Math.max(ans, dp1[i] + dp2[i] - 1);
        }

        return ans;
    }
    public static void main(String args[]) {
        int arr[] = {12, 11, 40, 5, 3, 1};
        int n = arr.length;
        System.out.println("The length of the longest bitonic subset is " + largestBitonic(arr, n));
    }
}