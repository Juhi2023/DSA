import java.util.*;

public class QuickSort{

    public static void quickSort(int arr[], int s, int e){
        if(s>=e)
            return;

        
        //sort around pivot element
        int pivotIndex = partitionWithFirstElementAsPivot(arr, s, e);
        
        //left part
        quickSort(arr, s, pivotIndex-1);

        //right part 
        quickSort(arr, pivotIndex+1, e);

    }
    public static int partitionWithLastElementAsPivot (int arr[], int s, int e){
        int pivot = arr[e];
        int i=s;

        for(int j=s; j<e; j++){
            if(arr[j]<=pivot){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[e];
        arr[e]= temp;

        return i;
    }

    public static int partitionWithFirstElementAsPivot (int arr[], int s, int e){
        int pivot = arr[s];
        int i=e;

        for(int j=e; j>s; j--){
            if(arr[j]>=pivot){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i--;
            }
        }

        int temp = arr[i];
        arr[i] = arr[s];
        arr[s]= temp;

        return i;
    }

    public static void main(String [] arg){
        int arr[]={4,6,7,3,2,8,2,10,5};
        quickSort(arr, 0, arr.length-1);

        for(int n : arr){
            System.out.print(n+" ");
        }
    }
}