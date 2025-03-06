import java.util.*;
class MinimumSumAbsoluteDifferencePair{

    public static int getMinSum(int[] a, int [] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int sum=0;
        int n=a.length;

        for(int i=0; i<n; i++){
            sum += Math.abs(a[i]-b[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 1, 3};
        System.out.println(getMinSum(a, b));
    }
}