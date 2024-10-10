import java.util.*;

public class SubSetSum{

    //Brute Force approach
    //Time complexity: O(2^n * n)
    //Space Complexity: O(2^n)

    //recusrion approach
    //Time complexity: O(2^n)
    //Space Complexity: O(2^n) [Storing Ans Space] + O(n)[Stack space]
    public static void getSubsetsUsingRecursion(List<Integer> sumset,int index, int[] nums, int sum) {
        if(index==nums.length){
            sumset.add(sum);
            return;
        }

        //include
        getSubsetsUsingRecursion(sumset, index+1, nums, sum+nums[index]);

        //dont include
        getSubsetsUsingRecursion(sumset, index+1, nums, sum);

    }

   
    public static void main(String [] args){
        int arr[]= {1,2,3};
        List<Integer> sumset = new ArrayList<>();
        getSubsetsUsingRecursion(sumset, 0, arr, 0);
        System.out.print(sumset);
    }
}