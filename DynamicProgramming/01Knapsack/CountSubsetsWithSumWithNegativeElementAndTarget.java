import java.util.*;

public class CountSubsetsWithSumWithNegativeElementAndTarget {

    public static int countSubsets(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return count(nums, 0, target, memo);
    }

    private static int count(int[] nums, int index, int target, Map<String, Integer> memo) {
        String key = index + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index == nums.length) {
            return target == 0 ? 1 : 0; // Found a valid subset if target == 0
        }

        int include = count(nums, index + 1, target - nums[index], memo);
        int exclude = count(nums, index + 1, target, memo);

        int totalWays = include + exclude;
        memo.put(key, totalWays);
        return totalWays;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1};
        int target = 0;

        int count = countSubsets(nums, target);
        System.out.println("Number of subsets with sum " + target + ": " + count);
    }
}
