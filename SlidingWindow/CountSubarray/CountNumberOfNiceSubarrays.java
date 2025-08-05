import java.util.*;
class CountNumberOfNiceSubarrays {
    
    //Brute Force
    //Time Complexity: O(N^2)
    //Space Complexity: O(1)

    //Optimized
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int helper(int[] nums, int k) {
        int l=0;
        int r=0;
        int ans=0;
        int cnt=0;
        int n = nums.length;
        while(r<n){
            if(nums[r]%2==1){
                cnt++;
            }
            while(cnt>k){
                if(nums[l]%2==1){
                    cnt--;
                }
                l++;
            }
            if(cnt<=k){
                ans+=r-l+1;
            }
            r++;
        }
        return ans;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k)-helper(nums, k-1);
    }

    public static void main(String [] arg){
        System.out.print(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }
}