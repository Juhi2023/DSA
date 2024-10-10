public class OddEven{

    public static void isEvenOrodd(int n){
        int result = n & 1;
        if(result==0)
            System.out.println("Even");
        else    
            System.out.println("Odd");

    }

    public static void main(String [] args){
        isEvenOrodd(5);
    }
}