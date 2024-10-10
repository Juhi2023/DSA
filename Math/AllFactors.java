
public class AllFactors{

    //Time Complexity:  O(sqrt(n))
    public static void printFactors(int n){

        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                System.out.print(i+ " ");
                if(n/i != i){
                    System.out.print(n/i+ " ");
                }
            }
        }

    }

    public static void main(String [] args){
        printFactors(36);
    }
}