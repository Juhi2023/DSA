import java.util.*;
class LemonadeChange{

    public static boolean lemonadeChange(int[] bills) {
        int five=0, ten=0;
        int i=0;
        while(i<bills.length){
            if(bills[i]==5)
                five++;
            else if(bills[i]==10){
                if(five==0){
                    return false;
                }
                five--;
                ten++;
            }else{
                if(ten>0 && five>0){
                    five--;
                    ten--;                        
                }else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }
            i++;
        }
        return true;

    public static void main(String[] args) {
        int[] bills = {1, 5, 3, 3, 4};
        System.out.println(lemonadeChange(bills));
    }
}