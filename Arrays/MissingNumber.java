import java.util.*;

public class MissingNumber{
    public static void getNumber(int nums[]){
        int total=0;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            total+= nums[i];
            sum+= i;
        }

        System.out.println("Missing Number: "+(sum + nums.length - total));
    }

    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int[] arr = {4, 0, 6, 3, 2, 1};
        getNumber(arr);
    }
}