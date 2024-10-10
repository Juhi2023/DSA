import java.util.* ;
class SearchInRotatedSortedArray{
    public static int search(int nums [], int target){
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=(low+high)/2;

            //if mid==target
            if(nums[mid]==target)
                return mid;
            
            // if low to mid array is sorted
            else if(nums[mid]>=nums[low]){
                //check if target exist in sorted array
                if(target>=nums[low] && target<nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            
            // if mid to high array is sorted
            else{
                //check if target exist in sorted array
                if(target>nums[mid] && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {4,5,6,7,1,2,3};

        System.out.println(search(arr, 5));
    }
}