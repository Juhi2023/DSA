import java.util.*;
class JumpGame{

    public static boolean canReach(int[] arr, int start) {
        if(start>=0 && start< arr.length && arr[start]>=0){
            if(arr[start]==0)
                return true;
            arr[start]= -arr[start];
            return canReach(arr, start+arr[start]) || canReach(arr, start-arr[start]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 3, 0, 0, 0, 9};
        System.out.println(canReach(nums, 5));
    }
}