
import java.util.*;

public class FloorAndCeilIngSortedArray{

    public static int findFloor(int arr[], int n, int x) {
        int index=-1;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid =(start+end)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]>x){
                end=mid-1;
            }else{
                start=mid+1;
                index=mid;
            }
        }
        return index;
    }

    public static int findCeil(int arr[], int n, int x) {
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

    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int f = findFloor(arr, n, x);
        int c = findCeil(arr, n, x);
        return new int[] {f, c};
    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = 6, x = 5;
        int[] ans = getFloorAndCeil(arr, n, x);
        System.out.println("The floor and ceil are: " + arr[ans[0]]+ " " + arr[ans[1]]);
    }
}