
import java.util.* ;
class FrequencyOftheMostFrequentElement{


    //Time Complexity: O(n * log n)
    //Space Complexity: O(1)
    public static int getLength(int[] nums, int k) {
        int l=0;
        int r=0;
        long sum=0;
        int ans=0;
        int n=nums.length;
        Arrays.sort(nums);

        while(r<n){
            int target = nums[r];
            sum+=target;
            while((long)(r-l+1)*target - sum >k){
                sum-= nums[l];
                l++;
            }
            ans=Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }


    public static void main(String [] arg){
        int nums [] = {1,2,4};
        System.out.print(getLength(nums, 5));
    }
}