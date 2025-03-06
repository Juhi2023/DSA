import java.util.*;
class JumpGame{

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