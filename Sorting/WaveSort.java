import java.util.*;

public class WaveSort{

    public static void swap(int arr[], int s, int e){
        int temp=arr[s];
        arr[s]=arr[e];
        arr[e]=temp;
    }

    public static void sort(int arr[]){

        int n=arr.length;
        
        if(n<=2)
            return;

        for(int i=1; i< n; i+=2){
            if(arr[i]>arr[i-1]){
                swap(arr, i, i-1);
            }

            if(i<=n-2 && arr[i]> arr[i+1]){
                swap(arr, i, i+1);
            }
        }

        for(int i=0; i< n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String [] arg){
        int arr[]={10, 5, 6, 3, 2, 20, 100, 80};
        sort(arr);
    }
}