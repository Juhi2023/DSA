import java.util.*;
class BinaryToDecimal{

    public static int convert(int n){
        int count=1;
        int sum=0;
        while(n>0){
            int res = n%10;
            sum = sum + (res * count);
            count*=2;
            n/=10;
        }
        return sum;
    }

    public static void main(String [] args){
        System.out.println(convert(111));
    }
}