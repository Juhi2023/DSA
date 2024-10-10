//https://leetcode.com/problems/count-good-numbers/

import java.util.* ;
class CountGoodNumbers{

    int mod=(int)1e9+7;

    public long power(long x, long n){
        if(n==0)
            return 1;

        int x = x % mod;
        if(n%2==0)
            return power((x)*(x), n/2) % mod ;

        return ((x) * power(x, n-1)) % mod;
    }

    public int countGoodNumbers(long n) {
        long evenI = (n+1)/2;
        long oddI = n/2;
        return (int)((power(5, evenI) * power(4, oddI)) % mod);
    }

    public static void main(String [] arg){
        System.out.print(countGoodNumbers(5));
    }
}