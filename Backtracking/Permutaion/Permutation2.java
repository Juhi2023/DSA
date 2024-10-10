import java.util.*;
class Permutation2{
    //array
    public static void findArrayPermutation( int index, List<List<Integer>> ans, int[] nums){
        // base case
        if(index == nums.length){
            List < Integer > ds = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = index; i<nums.length; i++){
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            swap(i, index, nums);
            findArrayPermutation(index+1, ans, nums);
            swap(i, index, nums);
        }
    }
    
    public static void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }



    public static void main(String args[]){
        //array permutation
        List<List<Integer>> ans = new ArrayList<>();
        int nums []= {2,2, 1, 1};
        findArrayPermutation(0, ans, nums);
        System.out.println(ans);

    }
}