import java.util.*;
class NextPermutation{

    //brute force
    public static void findNextPermutation( int index, List<List<Integer>> ans, int[] nums){
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
            findNextPermutation(index+1, ans, nums);
            swap(i, index, nums);
        }
    }
    public static void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    //optimized
    public static int[] findNextPermutationOptimized(int[] nums){
        int index = nums.length -2;
        while(index>=0 && nums[index]>=nums[index+1]){
            index--;
        }

        if(index==-1){
            reverse(nums, 0, nums.length-1);
            return nums;
        }

        int smallestIndex = nums.length - 1;
        while (nums[smallestIndex] <= nums[index]) {
            smallestIndex--;
        }
        swap(nums, index, smallestIndex);

        reverse(nums, index+1, nums.length-1);
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int nums[], int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }


    public static void main(String args[]){
        //array permutation
        List<List<Integer>> ans = new ArrayList<>();
        int nums []= {2,1,5,4,3,0,0};

        //brute force
        findNextPermutation(0, ans, nums);
        
        Collections.sort(ans, (row1, row2) -> {
            int minLength = Math.min(row1.size(), row2.size());
            for (int i = 0; i < minLength; i++) {
                int cmp = row1.get(i).compareTo(row2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(row1.size(), row2.size());
        });

        int index = ans.indexOf(Arrays.stream(nums).boxed().toList());
        if(index==ans.size()-1){
            System.out.println(ans.get(0));
        }else{
            System.out.println(ans.get(index+1));
        }
        
        //optimized
        int result[] = findNextPermutationOptimized(nums);
        for(int n: result){
            System.out.print(n+", ");
        }
    }
}