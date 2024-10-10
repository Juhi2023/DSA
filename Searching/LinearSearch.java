import java.util.*;

public class LinearSearch{

    public static int linearSearch(int arr[], int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==key)
                return i;
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
        System.out.println(linearSearch(arr, key));
    }
}