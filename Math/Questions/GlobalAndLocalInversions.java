//https://leetcode.com/problems/global-and-local-inversions/description/

import java.util.* ;
class GlobalAndLocalInversions{
    public static boolean isIdealPermutation(int nums []){
        for(int i=0; i<nums.length; i++){
            if(Math.abs(nums[i]-i)>1)
                return false;
        }
        return true;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {1,2, 0};

        System.out.print(isIdealPermutation(arr));
    }
}