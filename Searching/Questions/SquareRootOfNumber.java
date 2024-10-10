import java.util.*;
class SquareRootOfNumber{
    //Brute Force
    //Time Complexity: O(n)
    //Space Complexity: O(1)


    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int findSquareRootByBinarySearch(int n){
        int low = 1, high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= (long)(n)) {
                low = (int)(mid + 1);
            } else {
                high = (int)(mid - 1);
            }
        }
        return high;
    }

    public static void main(String args[]){
        System.out.println(findSquareRootByBinarySearch(9));
    }
}