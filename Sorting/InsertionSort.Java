import java.util.*;

public class InsertionSort{

    public static void sort(int arr[]){
        int n=arr.length;
        for(int i=1; i< n; i++){
            int curr=arr[i];  // assume to be at right place as in sorted array
            int prev = i-1;

            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }

            arr[prev+1] = curr;
        }
        for(int i=0; i< n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String [] arg){
        int arr[]={4,6,7,3,2,8,2,10,5};
        sort(arr);
    }
}