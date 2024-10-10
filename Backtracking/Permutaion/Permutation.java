import java.util.*;
class Permutation{
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
        
        for(int i = index; i<nums.length; i++){
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


    //string
    public static void findStringPermutation(String s, String ans, List<String> result){
        if(s.length()==0){
            result.add(ans);
            return;
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            String newStr= s.substring(0,i) + s.substring(i+1);
            findStringPermutation(newStr, ans+c, result);

        }
    }

    public static void main(String args[]){
        //array permutation
        List<List<Integer>> ans = new ArrayList<>();
        int nums []= {1,2,2};
        findArrayPermutation(0, ans, nums);
        System.out.println(ans);


        //string permutation
        List<String> ans2 = new ArrayList<>();
        findStringPermutation("ABC", "", ans2);
        System.out.println(ans2);
    }
}