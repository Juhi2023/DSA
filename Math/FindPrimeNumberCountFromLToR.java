
public class FindPrimeNumberCountFromLToR{

    //Approch 1: Time Complexity:  O((L-R)* sqrt(n))
    //Approch 2 (Sieve): Time Complexity:  O((L-R) +  (n log(log n))) where n=10^6 to get exch integer data
    //Approch 2 (Sieve with prefix sum): Time Complexity:  O((n log(log n)))
    
    //Time Complexity:  O(n log(log n))
    public static int countPrimeNumbersBySieveOfEratostheses(int l, int r){
        int  prime[] = new int[r+1];

        for (int i = 0; i <= r; i++)
            prime[i] = 1;

        for(int i=2; i<=r; i++){
            if(prime[i]==1){
                for(int j=i*i; j<=r; j+=i){
                    prime[j]=0;
                }
            }
            prime[i]= prime[i] + prime[i-1];
        }

        return prime[r]-prime[l];

    }

    public static void main(String [] args){
        System.out.println(countPrimeNumbersBySieveOfEratostheses(0, 100));
    }
}