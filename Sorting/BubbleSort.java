import java.util.*;

public class BubbleSort{

    public static void sort(int arr[]){
        int n=arr.length;
        for(int i=0; i< n; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
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