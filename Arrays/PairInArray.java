import java.util.*;

public class PairInArray{

    public static void printPair(int arr[]){
        int count=0;
        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j<arr.length ; j++){
                System.out.print("("+arr[i]+", "+ arr[j]+ ") ");
                count++;
            }
            System.out.println();
        }

        System.out.println("Total pairs: "+ count);

    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];

        System.out.println("Enter elements: ");
        for(int i=0; i<num; i++){
            arr[i]= in.nextInt();
        }

        printPair(arr);
    }
}