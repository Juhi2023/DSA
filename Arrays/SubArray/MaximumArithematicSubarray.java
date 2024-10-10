import java.util.*;

public class MaximumArithematicSubarray{

    public static void printMaxSubarray(int arr[]){
        int prevDiff=arr[1] - arr[0];
        int maxLength=2;
        int currLength=2;

        for(int i=2; i< arr.length; i++){
            int diff= arr[i] - arr[i-1];
            if(prevDiff == diff){
                currLength++;
            }else{
                prevDiff = diff;
                currLength=2;
            }

            if(maxLength < currLength){
                maxLength=currLength;
            }
        }

        System.out.println(maxLength);
    }

    public static void main(String []arg){
        int[] arr = {10, 7, 4, 6, 8, 11, 10};
        printMaxSubarray(arr);
    }
}