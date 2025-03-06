import java.util.*;
class MaxLengthChainOfPair{

    public static int getMaxLength(int[] nums) {
        Arrays.sort(nums, Comparator.comparing(o -> (int)o[1]));
        int len=1;
        int n = nums.length;
        int lastSelected = nums[0][1];
        

        for(int i=1; i<n; i++){
            if(nums[i][0]> lastSelected){
                len++;
                lastSelected = nums[i][1];
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2},{2,3},{3,4}};
        System.out.println(getMaxLength(a));
    }
}