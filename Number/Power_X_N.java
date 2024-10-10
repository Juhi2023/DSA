
public class Power_X_N{

    //Time Complexity:  O(log n)
    public static double power(double x, long n) {
       if(n==0)
            return  1;

        if(n%2==1)
            return x * power(x, n-1);
        
        return power(x * x, n/2);
    }
    
    public static double myPow(double x, int n) {

       if(n==0)
            return  1;

        if(n<0){
            return 1/power(x, -1 * (long)(n));
        }
        else
            return power(x, n);
    }



    public static void main(String [] args){
        System.out.println(myPow(2.1, 6));

        System.out.println(myPow(2.1, -6));
    }
}