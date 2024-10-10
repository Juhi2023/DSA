import java.util.*;
class FindPeakElement{
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int findPeakElementByLinearSearch(int nums[]){
        for(int i=0; i<nums.length; i++){
            if((i==0 || nums[i-1]<nums[i]) && (i==nums.length-1 || nums[i+1]<nums[i]))
                return i;
        }
        return -1;
    }

    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int findPeakElementByBinarySearch(int nums[]){
        int n=nums.length;
        if(n == 1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[n-1]>nums[n-2])
            return n-1;
        int start=1;
        int end=n-2;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            else if(nums[mid]>nums[mid-1])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public static void main(String args[]){
        int arr[] = {1,2};
        System.out.println(findPeakElementByBinarySearch(arr));
    }
}