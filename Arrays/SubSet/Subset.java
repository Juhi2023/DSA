import java.util.*;

public class SubSet{
    

    //iterative approach
    //Time complexity: O((2^n)*n)
    public static List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num: nums){
            int size = result.size();
            for(int i = 0; i < size; i++){
                List<Integer> temp = new ArrayList<>(result.get(i));
                temp.add(num);
                result.add(temp);
            }
        }
        return result;
    }

    //recusrion approach
    //Time complexity: O(2^n * n)
    public static void getSubsetsUsingRecursion(List<Integer> subset,int index, int[] nums) {
        if(index==nums.length){
            for(Integer num: subset){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        //include
        subset.add(nums[index]);
        getSubsetsUsingRecursion(subset, index+1, nums);

        //dont include
        subset.remove(subset.size() -1);
        getSubsetsUsingRecursion(subset, index+1, nums);

    }

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
        // getSubSetByBitManipulation(arr);

        getSubsetsUsingRecursion(new ArrayList<>(), 0, arr);

        // List<List<Integer>> result = getSubsets(arr);

        // for(List<Integer> r : result){
        //     for(Integer num : r){
        //         System.out.print(num+" ");
        //     }
        //     System.out.println();
        // }
    }
}