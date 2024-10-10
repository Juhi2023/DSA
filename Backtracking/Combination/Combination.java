import java.util.*;

public class Combination{

    //recusrion approach
    //Time complexity: O(2^target * k)
    //Space Complexity: O(k * X)
    // k: average size of combination and X: number of combination
    public static void getCombination(List<Integer> combination,List<List<Integer>> ans, int index, int[] nums, int target) {
        if (index == nums.length) {
            if (target == 0) {
                ans.add(new ArrayList < > (combination));
            }
            return;
        }

        if (nums[index] <= target) {
            combination.add(nums[index]);
            getCombination(combination, ans, index, nums, target - nums[index]);
            combination.remove(combination.size() - 1);
        }
        getCombination(combination, ans, index + 1, nums, target);

    }

   
    public static void main(String [] args){
        int arr[]= {2,3,6,7};
        List<List<Integer>> result = new ArrayList<>();
        getCombination(new ArrayList<>(), result, 0, arr, 7);
        System.out.print(result);
    }
}