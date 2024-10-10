public class PalindromeNumber{

    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;

        int num=x;
        int reverse=0;
        while(x>0){
            int part=x%10;
            reverse=reverse*10+part;
            x/=10;
        }
        if(num==reverse)
            return true;
        return false;
    }

    public static void main(String args[]){
        System.out.println(isPalindrome(454));
    }
}