//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

import java.util.* ;
class RemoveDuplicatesFromSortedArray{
    public static int removeDuplicate(int nums []){
        if (nums.length == 0) 
            return 0;

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;  
    
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {1,2,2,2,3,3};

        System.out.println(removeDuplicate(arr));
    }
}