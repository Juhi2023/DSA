
public class SieveOfEratostheses{

    //Time Complexity:  O(n * sqrt(n))
    public static void printPrimeNumbers(int n){
        if(n==0 || n==1){
            System.out.println(n+": Not a Prime");
            return;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                System.out.println(n+": Not a Prime");
                return;
            }
        }
        System.out.println(n+": Prime");

    }
    
    //Time Complexity:  O(n log(log n))
    public static void printPrimeNumbersBySieveOfEratostheses(int n){
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for(int i=2; i<=n; i++){
            if(prime[i]){
                for(int j=i*i; j<=n; j+=i){
                    prime[j]=false;
                }
            }
        }

        for(int i=2; i<=n; i++){
            if(prime[i]){
                System.out.print(i+ " ");
            }
        }

    }

    public static void main(String [] args){
        // for(int i=0; i<=50; i++){
        //     printPrimeNumbers(i);
        // }

        printPrimeNumbersBySieveOfEratostheses(50);
    }
}