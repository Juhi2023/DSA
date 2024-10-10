public class NumberOfOccurrence{
    public static int searchRange(int[] nums, int target) {
        int ans[] ={-1,-1};
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                ans[0]=mid;
                end=mid-1;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        start=0;
        end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                ans[1]=mid;
                start=mid+1;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        if(ans[0]==-1)
            return 0;
        return ans[1]-ans[0]+1;
    }

    public static void main(String []arg){
        int[] arr = {5,7,7,8,8,10};
        int ans = searchRange(arr, 1);
        System.out.println(ans);
    }
}
