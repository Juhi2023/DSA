//https://leetcode.com/problems/majority-element/description/

import java.util.* ;
class MajorityElement{
    
    //1. Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public static int majorityElementByBruteForce(int nums []){
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > (n / 2))
                return nums[i];
        }
        return -1;
    }

    //2. Using sorting
    // Time Complexity: O(N * log N)
    // Space Complexity: O(1)

    //3. Hash Map
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int majorityElementByHashMap(int nums []){
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }

    //4. Divide and Conquer
    // Time Complexity: O(N log N)
    // Space Complexity: O(N)
    public static int majorityElementByDivideAndConquer(int nums [], int start, int end){
        if(start==end)
            return nums[start];
        
        int mid = (start+end)/2;

        int leftMajorElement = majorityElementByDivideAndConquer(nums, start, mid);
        int rightMajorElement = majorityElementByDivideAndConquer(nums, mid+1, end);

        if(leftMajorElement == rightMajorElement)
            return leftMajorElement;

        int countL =0;
        int countR=0;

        for(int i=start; i<=end; i++){
            if(nums[i]==leftMajorElement)
                countL++;
            else if(nums[i]==rightMajorElement)
                countR++;
        }

        if(countL>countR)
            return leftMajorElement;
        return rightMajorElement;
    }

    //5. Moore voting algorithm
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int majorityElementByMoreVotingAlgo(int nums []){
        int n=nums.length;
        int currElement = 0;
        int count=0;
        for(int i=0; i<n; i++){
            if(count==0){
                count++;
                currElement = nums[i];
            }else if(nums[i]==currElement)
                count++;
            else 
                count--;
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == currElement) 
                count++;
        }

        if (count > (n / 2)) 
            return currElement;
        return -1;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {1,2,2,2,3,3};

        System.out.println(majorityElementByMoreVotingAlgo(arr));
    }
}