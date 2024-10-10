import java.util.*;

public class LargestNumber{
    public static int largestNumber(int arr[]){
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(largest<arr[i])
                largest=arr[i];
        }
        return largest;
    }

    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];

        System.out.println("Enter elements: ");
        for(int i=0; i<num; i++){
            arr[i]= in.nextInt();
        }

        System.out.println("Largest Value: "+ largestNumber(arr));
    }
}