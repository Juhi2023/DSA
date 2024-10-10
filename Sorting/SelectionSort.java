import java.util.*;

public class SelectionSort{

    public static void sort(int arr[]){
        int n=arr.length;
        for(int i=0; i< n; i++){
            int pos=i;
            for(int j=i; j<n; j++){
                if(arr[j]<arr[pos]){
                    pos=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[pos];
            arr[pos]=temp;
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