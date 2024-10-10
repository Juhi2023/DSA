
public class SquareRootOfNumber{

    //Time Complexity:  O(n)
    public static long floorSqrt(long n) {
       long ans = 0;
        for (long i = 1; i <= n; i++) {
            long val = i * i;
            if (val <= n) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }
    
    // Using Binary Search
    //Time Complexity:  O(log n)
    public static long floorSqrtByBinarySearch(long n) {
        long low = 1, high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }



    public static void main(String [] args){
        System.out.println(floorSqrtByBinarySearch(6));
    }
}