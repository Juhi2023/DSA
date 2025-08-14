//https://leetcode.com/problems/split-array-largest-sum/description/
//Similar to book allocation and painter's partition

// Java code to iterate through
// every possible solution
import java.util.*;

class SplitArrayLargestSum {

    //Time Complexity: O(n^k)
    //Space Complexity: O(k)
    public static void solve(int[] arr, int k, int index, int[] ans) {
        int n = arr.length;
        int sum = 0;
        if (k == 0) {
            if (index == n) {
                ans[0] = Math.min(ans[0], maxsum);
            }
            return;
        }


        for (int i = index; i < n; i++) {
            sum += arr[i];
            maxsum = Math.max(maxsum, sum);   
            solve(arr, k - 1, i + 1, maxsum, ans);
        }
    }

    //DP: Memoization
    //Time Complexity: O(n*n*k)
    //Space Complexity: O(n*k)
    public static int solve(int[] arr, int k, int index) {
        int n = arr.length;
        if (k == 0) {
            return (index == n) ? 0 : Integer.MAX_VALUE;
        }

        if (memo[index][k] != -1) {
            return memo[index][k];
        }

        int sum = 0;
        int minLargestSum = Integer.MAX_VALUE;

        for (int i = index; i < n; i++) {
            sum += arr[i];
            int result = solve(arr, k - 1, i + 1);
            if (result != Integer.MAX_VALUE) {
                minLargestSum = Math.min(minLargestSum, Math.max(sum, result));
            }
        }

        return memo[index][k] = minLargestSum; 
    }

    public static int splitArray(int[] arr, int k) {
        int n = arr.length;
        int memo[][] = new int[n][k + 1]; 
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(arr, k, 0);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 3;
        System.out.println(splitArray(arr, k));
    }
}
