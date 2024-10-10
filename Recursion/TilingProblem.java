
public class TilingProblem{

    //for Domino only
    public static int tiling(int n) {
        if(n==0 || n==1)
            return  1;

        int w1 = tiling(n-1);
        int w2 = tiling(n-2);

        return w1+w2;
    }

    public static void main(String [] args){
        System.out.println(tiling(1));
    }
}