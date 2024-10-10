
import java.util.*;

public class ImplementUpperBound{

    public static int findCeil(long arr[], int n, long x) {
        int index=-1;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid =(start+end)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]>x){
                index=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return index;
    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        long[] arr = {1,2,8,10,11,12,19};

        System.out.println(findCeil(arr, arr.length, 5));
    }
}