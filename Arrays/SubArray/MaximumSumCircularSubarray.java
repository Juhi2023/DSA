import java.util.*;

public class MaximumSumCircularSubarray{

    public static int maxSubArraySumByKadanes(int arr[]){
        if(arr.length==0)
            return 0;

        int maxSum=Integer.MIN_VALUE;
        int currSum=0;

        for(int i=0; i<arr.length; i++){
            currSum += arr[i];
            if(maxSum<currSum)
                maxSum=currSum;

            if(currSum<0)
                currSum=0;
        }
        

        return maxSum;

    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {4, -4, 6, -6, 10, -11, 12};

        //sum without circcular
        int nonWrapSum = maxSubArraySumByKadanes(arr);

        //sum in circular
        int total =0;
        for(int i=0; i<arr.length; i++){
            total += arr[i];
            arr[i] = -arr[i];
        }
        int wrapSum= total + maxSubArraySumByKadanes(arr);

        int MaxSum = wrapSum == 0 ? nonWrapSum :  Math.max(wrapSum, nonWrapSum);
        System.out.println(MaxSum);
    }
}