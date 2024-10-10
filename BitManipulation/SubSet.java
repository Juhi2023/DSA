import java.util.*;

public class SubSet{
    

    //Time complexity: O((2^n) * n)
    public static void getSubSetByBitManipulation(int nums []){
        int n= nums.length;
        for(int i=0; i< (1<<n); i++){    // 1< 2^n
            for(int j=0; j<n; j++){      //  n
                if((i & (1<<j))!=0){
                    System.out.print(nums[j]+" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String [] args){
        int arr[]= {1,2,3};
        getSubSetByBitManipulation(arr);
    }
}