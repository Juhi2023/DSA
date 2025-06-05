import java.util.*;
class JumpGame{

    //DP- memoization
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    // {2, 3, 0, 0, 0, 4};
    public static boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        return canJumpFromPosition(0, nums, memo);
    }
    
    private static boolean canJumpFromPosition(int position, int[] nums, int[] memo) {
        if (memo[position] != 0) {
            return memo[position] == 1;
        }

        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums, memo)) {
                memo[position] = 1;
                return true;
            }
        }

        memo[position] = -1;
        return false;
    }


    //Greedy
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static boolean canReachEnd(int nums[]){
        int maxIndex=0;
        for(int i=0; i< nums.length; i++){
            if(i> maxIndex)
                return false;
            maxIndex = Math.max(maxIndex, i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 3, 0, 0, 0, 9};
        System.out.println(canReachEnd(nums));
    }
}