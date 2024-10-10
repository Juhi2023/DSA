import java.util.*;
class DecimalToBinary{

    public static int convert(int n){
        int sum=0;
        int count=1;
        while(n>0){
            int res = n%2;
            sum = sum + res * count;
            n/=2;
            count*=10;
        }
        return sum;
    }

    public static void main(String [] args){
        System.out.println(convert(4));
    }
}