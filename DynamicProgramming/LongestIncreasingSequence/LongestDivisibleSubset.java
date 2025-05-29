import java.util.*;

class LongestDivisibleSubset {
    //Alternate tabulation approch as used in Print LIS
    //Time Complexity: O(N*N)
    //Space Complexity: O(N)
    
    static List<Integer> largestSubset(int nums[], int n) {
        Arrays.sort(nums);
        int dp[] = new int[n];

        int hash[] = new int[n];
        for(int i=0; i<n; i++){
            hash[i]=i;
            for(int prev=0; prev<=i-1; prev++){
                if(nums[i]%nums[prev]==0 && dp[i]<1+dp[prev]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
        }
        int ans=-1, lastIndex=-1;
        for(int i=0; i<n; i++){
            if(ans<dp[i]){
                ans=dp[i];
                lastIndex=i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            res.add(nums[lastIndex]);
        }
        return res;
    }
    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;
        System.out.println("The length of the longest divisible subset is " + largestSubset(arr, n));
    }
}