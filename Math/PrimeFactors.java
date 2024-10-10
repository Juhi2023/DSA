import java.util.*;
public class PrimeFactors{

    public static void mySieve(int[] prime, int n) {
        for (int i = 1; i <= n; i++) {
            prime[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (prime[j] == j)
                        prime[j] = i;
                }
            }
        }
    }
    public static void printFactors(int N) {
        List<Integer> ans = new ArrayList<>();
        int[] prime = new int[N + 1];
        mySieve(prime, N);

        while (N != 1) {
            ans.add(prime[N]);
            N = N / prime[N];
        }
        
        for(Integer n : ans){
            System.out.print(n+" ");
        }
    }


    public static void main(String [] args){
        printFactors(36);
    }
}