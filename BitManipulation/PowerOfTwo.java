public class PowerOfTwo{

    public static boolean isPowerOfTwo(int n){
        return n>0 && (n & (n-1)) == 0 ? true : false;
    }

    public static void main(String [] args){
        System.out.println(isPowerOfTwo(5));
    }
}