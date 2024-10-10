
public class FriendsPairingProblem{

    public static int getWays(int n) {
        if(n==1 || n==2)
            return  n;

        int f1 = getWays(n-1); //single choice
        int f2 = getWays(n-2); //pair
        int pairWays = (n-1) * f2;

        return f1 + pairWays;
    }

    public static void main(String [] args){
        System.out.println(getWays(4));
    }
}