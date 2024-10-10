import java.util.*;

public class CountAllSubsequencesWithSumK{

    //Brute Force
    //Time Complexity: O(2^N) 
    //Space Complexity: O(2^n) [Storing Ans Space] + O(n)[Stack space]
    public static int count(int nums[], int elementInSubest, int target, int index){
        if(index==nums.length){
            if(target==0 && elementInSubest>0)
                return 1;
            return 0;
        }
        
        int leftCount = count(nums, elementInSubest+1, target - nums[index], index+1);
        int rightCount = count(nums, elementInSubest, target, index+1);

        return leftCount + rightCount;
    }

    public static void main(String [] arg){
        int nums[]={5, 2, 3, 10, 6, 8};
        System.out.println(count(nums, 0, 10, 0));
    }
}