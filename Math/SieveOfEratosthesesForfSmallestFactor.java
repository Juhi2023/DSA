
public class SieveOfEratosthesesForfSmallestFactor{
    
    //Time Complexity:  O(n log(log n))
    public static void printSmallestFactorBySieveOfEratostheses(int n){
        int  prime[] = new int[n+1];
        for(int i=0; i<=n; i++){
            prime[i]=i;
        }

        for(int i=2; i<=n; i++){
            if(prime[i]==i){
                for(int j=i*i; j<=n; j+=i){
                    prime[j]=i;
                }
            }
        }
        
        for(int i=2; i<=n; i++){
            System.out.print(prime[i]+ " ");
        }
    }

    public static void main(String [] args){
        printSmallestFactorBySieveOfEratostheses(50);
    }
}