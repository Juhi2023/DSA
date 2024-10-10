import java.util.*;
public class RotateArray {
  public static void reverse(int[] arr, int start, int end) {
    while (start <end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  public static void rotateToLeft(int[] arr, int k) {
    int n = arr.length;
    reverse(arr, 0, k - 1);
    reverse(arr, k , n - 1);
    reverse(arr, 0, n - 1);
  }

  public static void rotateToRight(int[] arr, int k) {
    int n = arr.length;
    reverse(arr, 0, n - k - 1);
    reverse(arr, n - k, n - 1);
    reverse(arr, 0, n - 1);
  }

  public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;
        int k = 10;
        k %= n;

        rotateToLeft(arr, k);
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        int [] nums = {1,2,3,4,5,6,7};
        rotateToRight(nums, k);
        for (int i = 0; i < n; i++){
            System.out.print(nums[i] + " ");
        }
    }
}