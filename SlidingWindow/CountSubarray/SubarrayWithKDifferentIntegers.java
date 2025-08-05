import java.util.*;
class SubarrayWithKDifferentIntegers {
    
    //Brute Force
    //Time Complexity: O(N^2)
    //Space Complexity: O(1)

    //Optimized
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int helper(int[] nums, int k) {
        int l=0;
        int r=0;
        int cnt=0;
        int n=nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();


        while(r<n){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l], map.get(nums[l])-1);
                map.remove(nums[l], 0);
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k)-helper(nums, k-1);
    }

    public static void main(String [] arg){
        System.out.print(numberOfSubarrays(new int[]{1,2,1,2,3}, 2));
    }
}