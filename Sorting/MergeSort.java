import java.util.*;

public class MergeSort{

    public static void mergeSort(int arr[], int s, int e){
        if(s>=e)
            return;

        int mid = (s+e)/2;
        //left part
        mergeSort(arr, s, mid);

        //right part 
        mergeSort(arr, mid+1, e);

        merge(arr, s, mid, e);
    }
    public static void merge (int arr[], int s, int mid, int e){
        int temp [] = new int [e-s+1];
        //iterator
        int l=s;
        int r=mid+1;
        int k=0;

        while(l<=mid && r<=e){
            if(arr[l]<arr[r]){
                temp[k]=arr[l];
                l++;
            }else{
                temp[k]=arr[r];
                r++;
            }
                k++;
        }

        while(l<=mid){
            temp[k++]= arr[l++];
        }
        while(r<=e){
            temp[k++]= arr[r++];
        }

        //copy temp to arr
        for(int i=s; i-s<temp.length; i++){
            arr[i] = temp[i-s];
        }
    }

    public static void main(String [] arg){
        int arr[]={4,6,7,3,2,8,2,10,5};
        mergeSort(arr, 0, arr.length-1);

        for(int n : arr){
            System.out.print(n+" ");
        }
    }
}