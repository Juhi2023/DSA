//https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0?category&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=max-sum-in-sub-arrays

import java.util.*;

public class MaximumScoreFromSubarrayMinimums{

    public static int pairWithMaxSum(int [] arr) {
        int n = arr.length;
        int maxSum = 0;
        int currSum = 0;
        for(int i = 0; i < n-1; i++){
            currSum = arr[i] + arr[i+1];
            if(currSum > maxSum){
                maxSum = currSum;
            }
        }
        return maxSum;
        
    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {4,1,3,5,6};

        System.out.println(pairWithMaxSum(arr));
    }
}