import java.util.*;

public class CheckSubsequencesWithSumKExist{

    //Brute Force
    //Time Complexity: O(2^N) 
    //Space Complexity: O(2^n) [Storing Ans Space] + O(n)[Stack space]
    public static boolean count(int nums[], int elementInSubest, int target, int index){
        if(index==nums.length){
            if(target==0 && elementInSubest>0)
                return true;
            return false;
        }
        
        if(count(nums, elementInSubest+1, target - nums[index], index+1))
            return true;
        if(count(nums, elementInSubest, target, index+1))
            return true;
        return false;
    }

    public static void main(String [] arg){
        int nums[]={5, 2, 3, 10, 6, 8};
        System.out.println(count(nums, 0, 10, 0));
    }
}