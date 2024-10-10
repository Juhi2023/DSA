import java.util.*;
class KokoEatingBananas{
    //Time Complexity: O(max(a[]) * N),
    //Space Complexity: O(1)
    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }

    public static int minimumRateToEatBananasByBrute(int[] v, int h) {
        //Find the maximum number:
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }

        //Find the minimum value of k:
        for (int i = 1; i <= maxi; i++) {
            int reqTime = calculateTotalHours(v, i);
            if (reqTime <= h) {
                return i;
            }
        }

        //dummy return statement
        return maxi;
    }

    //Time Complexity: (N * log(max(a[])))
    //Space Complexity: O(1)
    public static int minimumRateToEatBananasByBinarySearch(int[] v, int h) {
        //Find the maximum number:
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        int low = 1, high = maxi;

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(v, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String args[]){
        int[] v = {7, 15, 6, 3};
        int h = 8;
        int ans = minimumRateToEatBananasByBinarySearch(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
}