import java.util.* ;
class FindMinimumInRotatedSortedArray{
    public static int getRotation(int nums []){
        int low=0;
        int high=nums.length-1;
        int ans=nums[0];

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=nums[low]){
                if(ans>nums[low])
                    ans=nums[low];
                low=mid+1;
            }else{
                if(ans>nums[mid])
                    ans=nums[mid];
                high=mid-1;
            }
        }
        return ans;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {5,1,2,3,4};

        System.out.println(getRotation(arr));
    }
}