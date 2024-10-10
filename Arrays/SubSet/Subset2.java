import java.util.*;

public class SubSet2{

    //Brute Force
    //Time complexity: O(2^n * n) + O(N * log N) + O(N)
    //Space Complaxity: O(2^n)
    public static void getSubsetWithoutDuplicateBruteForce(List<Integer> subset,int index, int[] nums, List<List<Integer>> ans) {
        if(index==nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        //include
        subset.add(nums[index]);
        getSubsetWithoutDuplicateBruteForce(subset, index+1, nums, ans);

        //dont include
        subset.remove(subset.size() -1);
        getSubsetWithoutDuplicateBruteForce(subset, index+1, nums, ans);

    }

    public static void getSubsetWithoutDuplicate(int index, int nums[], List<Integer> temp, List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for(int i=index; i<nums.length; i++){
            if(i!=index && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            getSubsetWithoutDuplicate(i+1, nums, temp, ans);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String [] args){
        int arr[]= {1,2,2};
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        // getSubsetWithoutDuplicateBruteForce(new ArrayList<>(), 0, arr, ans);
        // System.out.print(new ArrayList<>(new HashSet<>(ans)));

        getSubsetWithoutDuplicate(0, arr, new ArrayList<>(), result);
        System.out.print(result);

    }
}