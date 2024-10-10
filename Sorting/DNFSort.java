import java.util.*;

public class DNSort{

    public static void swap(int arr[], int s, int e){
        int temp=arr[s];
        arr[s]=arr[e];
        arr[e]=temp;
    }

    public static void sort(int arr[]){

        int high=arr.length-1, low=0, mid=0;

        if(high<1)
            return;
        
        while(mid<=high){
            //need yo use if else or switch to use only one operation at a time **********
            if(arr[mid]==0){
                swap(arr, low, mid);
                low++;
                mid++;
            }else if(arr[mid]==1){    
                mid++;
            }else{
                swap(arr, high, mid);
                high--;
            }
        }

        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String [] arg){
        int arr[]={2, 0, 1, 0, 0,  2, 1, 0, 2, 1};
        sort(arr);
    }
}