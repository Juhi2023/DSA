import java.util.*;
class HexaToDecimal{

    public static int convert(String n){
        int count=1;
        int sum=0;

        int i=n.length()-1;
        while(i>=0){
            if(n.charAt(i)>='A' && n.charAt(i)<='F'){
                sum+=count* (n.charAt(i)-'A'+10);
            }else{
                sum+=count* (n.charAt(i)-'0');
            }
            count*=16;
            i--;
        }
        return sum;
    }

    public static void main(String [] args){
        System.out.println(convert("F"));
    }
}