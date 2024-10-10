import java.util.*;

public class CountOfSmallerNumbersAfterSelf{

    //using binary search
    public static List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        List<Integer> ans = new ArrayList <>();
        List<Integer> sorted = new ArrayList<>();

        for(int i=n-1; i>=0; i--){
            int pos = findInsertPosition(sorted, nums[i]);
            sorted.add(pos, nums[i]);
            ans.add(pos);
        }
        Collections.reverse(ans);  
        return ans;
    }

    public static int findInsertPosition(List<Integer> sorted, int n){
        int l=0;
        int r= sorted.size();

        while(l<r){
            int mid=(l+r)/2;
            if(n<=sorted.get(mid))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    //using merge sort
    public static  void mergeSort(int arr[][], int result[], int s, int e){
        if(s>=e)
            return;

        int mid=(s+e)/2;
        mergeSort(arr, result, s, mid);
        mergeSort(arr, result, mid+1, e);

        merge(arr, result, s, mid, e);
    }

    public static void merge(int arr[][], int result[], int s, int mid, int e){
        int temp[] = new int[e-s+1];
        int l=s;
        int r=mid+1;
        int k=0;
        int count=0;

        //ordering in descending order
        while(l<=mid && r<=e){
            if(arr[l][0]>arr[r][0]){
                result[arr[l][1]]+= e-r+1;
                // result[arr[l][1]]+= count;
                temp[k]=arr[l][0];
                l++;
            }else{
                temp[k]=arr[r][0];
                r++;
                // count++;
            }
            k++;
        }

        while(l<=mid){
            // result[arr[l][1]]+= count;
            temp[k++]= arr[l++][0];
        }
        while(r<=e){
            temp[k++]= arr[r++][0];
        }

        //copy temp to arr
        for(int i=s; i-s<temp.length; i++){
            arr[i][0] = temp[i-s];
        }
    }


    public static void main(String [] arg){
        int arr[]={5,2,6,1};
        //System.out.print(countSmaller(arr));


        int n=arr.length;
        int pair[][] = new int [n][n];
        for(int i=0; i<n; i++){
            pair[i][0]=arr[i];
            pair[i][1]=i;
        }

        int result[]= new int[n];
        mergeSort(pair, result, 0, n-1);
        for(int x: result){
            System.out.print(x+" ");
        }
    }
}