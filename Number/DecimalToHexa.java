import java.util.*;
class DecimalToHexa{

    public static String convert(int n){
        StringBuilder s = new StringBuilder("");
        int x=1;
        while(x<=n)
            x*=16;
        x/=16;

        while(x>0){
            int firstDigit = n/x;
            n-= firstDigit*x;
            x/=16;

            if(firstDigit>= 0 && firstDigit<=9){
                s.append(firstDigit);
            }else{
                s.append((char)('A'-10 + firstDigit));
            }
        }

        return s.toString();
    }

    public static void main(String [] args){
        System.out.println(convert(475));
    }
}