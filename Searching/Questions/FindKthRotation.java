import java.util.* ;
class FindKthRotation{
    public static int getRotation(int nums []){
        int low=0;
        int high=nums.length-1;
        int ans=nums[0];
        int index=0;

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=nums[low]){
                if(ans>nums[low]){
                    ans=nums[low];
                    index = low;
                }
                    
                low=mid+1;
            }else{
                if(ans>nums[mid]){
                    ans=nums[mid];
                    index=mid;
                }
                    
                high=mid-1;
            }
        }
        return index;
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {5,1,2,3,4};

        System.out.println(getRotation(arr));
    }
}