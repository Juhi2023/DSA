import java.util.*;

public class ReversePairs{

    public static int mergeSort(int nums[], int start, int end){
        if(start>=end)
            return 0;

        int mid = (start+end)/2;
        int leftC = mergeSort(nums, start, mid);
        int rightC = mergeSort(nums, mid+1, end);
        int cnt = countPairs(nums, start, mid, end);
        merge(nums, start, mid, end);
        return leftC+rightC + cnt;
    }

    public static int countPairs(int nums[], int start, int mid, int end){
        int cnt=0;
        int j=mid+1;
        for(int i=start; i<=mid; i++){
            while(j<=end && nums[i]> 2* (long)nums[j])
                j++;
            cnt+= j - (mid +1);
        }
        return cnt;
    }

    public static void merge(int nums[], int start, int mid, int end){
        int temp[] =new int [end-start+1];
        int k=0;
        int j=start;
        int i=mid+1;
        while(j<=mid && i<=end){
            if(nums[j]<nums[i]){
                temp[k++]=nums[j++];
            }else{
                temp[k++]=nums[i++];
            }
        }
        while(j<=mid){
            temp[k++]=nums[j++];
        }
        while(i<=end){
            temp[k++]=nums[i++];
        }

        for(int m=0; m<temp.length; m++){
            nums[start+m] = temp[m];
        }
    }


    public static void main(String [] arg){
        int arr[]={1,3,2,3,1};
        System.out.print(mergeSort(arr, 0, arr.length-1));
    }
}