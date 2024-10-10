import java.util.*;
class FindTheSmallestDivisor{
    //Time Complexity: O(max(a[]) * N),
    //Space Complexity: O(1)
    public static int helper(int[] v, int divisor) {
        int sum = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)(v[i]) / (double)(divisor));
        }
        return sum;
    }

    //Time Complexity: (N * log(max(a[])))
    //Space Complexity: O(1)
    public static int bySmallestDivisorByBinarySearch(int[] v, int th) {
        //Find the maximum number:
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        int low = 1, high = maxi;

        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = helper(v, mid);
            if (sum <=th) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String args[]){
        int[] v = {1,2,5,9};
        int h = 6;
        int ans = bySmallestDivisorByBinarySearch(v, h);
        System.out.println(ans);
    }
}