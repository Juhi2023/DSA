public class SingleElementInSortedArray{

    public static int getUniqueNumber1(int []nums){
        int s=0; 
        int e=nums.length-1;
        while(s<e){
            int mid = (s+e)/2;

            if(mid%2==1)
                mid--;
            
            if(nums[mid]==nums[mid+1]){
                s=mid+2;
            }else{
                e=mid;
            }
        }
        return nums[s];
    }

    //Time complexity: O(log n)
    public static int getUniqueNumber2(int []nums){
        int n=nums.length;
        //nums of length 1
        if(n == 1)
            return nums[0];
        //check if unique element exist at first place
        if(nums[0]!=nums[1])
            return nums[0];
        //check if unique element exist at last place
        if(nums[n-1]!=nums[n-2])
            return nums[n-1];

        int start =1;
        int end = nums.length-2;
        while(start<=end){
            int mid = (Start+end)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])    
                return nums[mid];
            else if((mid%2==0 && nums[mid+1]==nums[mid])|| (mid%2==1 && nums[mid]==nums[mid-1])){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }

        return -1;
    }

    public static void main(String [] args){
        int [] arr = {1,1,2,3,3,4,4,8,8};
        System.out.println(getUniqueNumber2(arr));
    }
}