class CheckSortedArray{    
    public static boolean check(int nums[], int i){
        if(nums.length==i)
            return true;
        if(nums[i]>nums[i+1])
            return false;

        return check(nums, i+1);
    }

    public static void main(String []args){
        int [] arr ={1,2,3,4,5,6,0};
        System.out.println(check(arr, 0));
    }
}