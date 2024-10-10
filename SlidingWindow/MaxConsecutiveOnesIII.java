//https://leetcode.com/problems/max-consecutive-ones-iii/description/

import java.util.* ;
class MaxConsecutiveOnesIII{

    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
    public static int getLengthByBruteForce(int nums[], int k) {

        if(nums.length==0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) 
        {
            int zeros=0;
            for (int j = i; j < nums.length; j++){
                if (nums[j]==0) {
                    if(zeros==k){
                        break;
                    }
                    zeros++;
                }
                maxans = Math.max(maxans, j - i+1);
            }
        }
        return maxans;
    }

    //Time Complexity: O(2N)
    //Space Complexity: O(1)
    public static int getLengthBySlidingWindow(int nums[], int k) {
        int maxLength =0;
        int l=0;
        int zeros=0;

        for(int r=0; r<nums.length; r++){
            if(nums[r]==0)
                zeros++;
            while(zeros>k){
                if(nums[l]==0)
                    zeros--;
                l++;
            }
            if(zeros<=k){
                maxLength = Math.max(maxLength, r-l+1);
            }

        }
        return maxLength;
    }


    public static void main(String [] arg){
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.print(getLengthBySlidingWindow(nums, 2));
    }
}