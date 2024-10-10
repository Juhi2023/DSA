import java.util.*;

public class PrintSubarrays{

    public static void printSubarrays(int arr[]){
        int count=0;
        for(int i=0; i< arr.length; i++){
            int start=i;
            
            for(int j=i; j<arr.length ; j++){
                int end=j;

                for(int k=start; k<=end; k++){
                    System.out.print(arr[k] + " ");
                }
                count++;
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Total subarrays: "+ count);

    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];

        System.out.println("Enter elements: ");
        for(int i=0; i<num; i++){
            arr[i]= in.nextInt();
        }

        printSubarrays(arr);
    }
}