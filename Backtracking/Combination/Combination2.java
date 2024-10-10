import java.util.*;

public class Combination2{

    //recusrion approach : SAME AS SUBSET 2 CODE
    //Time complexity: O(2^n * k) 
    //Space Complexity: O(k * X)
    // k: average size of combination and X: number of combination
    public static void getCombination(List<Integer> combination,List<List<Integer>> ans, int index, int[] nums, int target) {
        if (target == 0) {
            ans.add(new ArrayList < > (combination));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if(i!=index && nums[i]==nums[i-1])
                continue;

            if (nums[i] > target) 
                return;

            combination.add(nums[i]);
            getCombination(combination, ans, i+1, nums, target - nums[i]);
            combination.remove(combination.size() - 1);
        }


    }

   
    public static void main(String [] args){
        int arr[]= {10,1,2,7,6,1,5};
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        getCombination(new ArrayList<>(), result, 0, arr, 8);
        System.out.print(result);
    }
}