class LastOccurance{    
    public static int getLastOccurance(int nums[], int i, int key){
        if(i<0)
            return -1;
        if(nums[i]==key)
            return i;

        return getLastOccurance(nums, i-1, key);
    }

    public static void main(String []args){
        int [] arr ={1,4,3,4,5,6,0};
        System.out.println(getLastOccurance(arr, arr.length-1, 4));
    }
}