class FirstOccurance{    
    public static int getfirstoccurance(int nums[], int i, int key){
        if(nums.length==i)
            return -1;
        if(nums[i]==key)
            return i;

        return getfirstoccurance(nums, i+1, key);
    }

    public static void main(String []args){
        int [] arr ={1,4,3,4,5,6,0};
        System.out.println(getfirstoccurance(arr, 0, 4));
    }
}