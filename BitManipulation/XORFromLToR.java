public class XORFromLToR{

    public static int getValue(int n){
        if(n%4==0)
            return n;
        else if(n%4==1)
            return 1;
        else if(n%4==2)
            return n+1;
        return 0;
    }

    public static int getXOR(int left, int right){
        return getValue(left-1) ^ getValue(right);     //((1^2^3)  ^ (1^2^3^4^5^6^7^8))
    }

    public static void main(String [] args){
        int result = getXOR(4, 8);
        System.out.println(result);
    }
}