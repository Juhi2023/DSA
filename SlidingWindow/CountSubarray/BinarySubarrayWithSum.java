import java.util.*;

class BinarySubarrayWithSum{

    //Using hash map and prefix sum 
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int subarraySum(int arr[], long k){
        int count=0;
        long sum=0;
        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];

            long rem = sum - k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }

    //Using Sliding window
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int subarraySumBySW(int[] nums, int k) {
        int l = 0;
        int zeros = 0;
        int currentSum = 0;
        int totalCount = 0;

        for (int r = 0; r < nums.length; r++) {
            currentSum += nums[r];
            
            while (l < r && (nums[l] == 0 || currentSum > k)) {
                if (nums[l] == 1) {
                    zeros = 0;
                } else {
                    zeros++;
                }
                
                currentSum -= nums[l];
                l++;
            }
            
            if (currentSum == k) {
                totalCount += 1 + zeros;
            }
        }
        
        return totalCount;
    }

    //Using Sliding window
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    private static int atMost(int[] nums, int k) {
        int l = 0, currentSum = 0, totalCount = 0;

        for (int r = 0; r < nums.length; r++) {
            currentSum += nums[r];

            while (l <= r && currentSum > k) {
                currentSum -= nums[l++];
            }

            totalCount += r - l + 1;
        }
        return totalCount;
    }

    public static int subarraySumBySWOtherWay(int[] nums, int k) {
        return atMost(nums, k)- atMost(nums, k-1);
    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {1,0,1,0,1};
        System.out.print(subarraySumBySW(arr, 2));
    }
}