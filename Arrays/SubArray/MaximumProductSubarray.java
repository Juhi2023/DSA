import java.util.*;

public class MaximumProductSubarray{

    public static int printMaxSubarrayProduct(int arr[]){
        int maxProd = Integer.MIN_VALUE;
        int prod=1;
        //traverse in right
        for(int i=0; i<nums.length; i++){
            prod *=nums[i];
            maxProd = Math.max(maxProd, prod);
            if(prod==0)
                prod=1;
        }
        prod=1;
        //traverse in left
        for(int i=nums.length-1; i>=0; i--){
            prod *=nums[i];
            maxProd = Math.max(maxProd, prod);
            if(prod==0)
                prod=1;
        }

        return maxProd;
    }

    public static void main(String []arg){
        int[] arr = {2,3,-2,4};
        printMaxSubarrayProduct(arr);
    }
}