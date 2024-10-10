import java.util.*;

public class BinarySearch{
    public static int binarySearch(int[] arr, int key){
        if(arr.length==0){
            return -1;
        }

        int start=0, end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;

            if(arr[mid]==key)
                return mid;
            else if(arr[mid]>key)
                end = mid-1;
            else
                start = mid+1;
        }

        return -1;
    }

    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];

        System.out.println("Enter elements: ");
        for(int i=0; i<num; i++){
            arr[i]= in.nextInt();
        }

        System.out.println("Enter key to be search: ");
        int key= in.nextInt();

        System.out.println("Index: " + binarySearch(arr, key));
    }
}