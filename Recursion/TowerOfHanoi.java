import java.util.*;

public class TowerOfHanoi{

    public static void printSteps(int n, String src, String helper, String dest){
        if(n==0)
            return;
        printSteps(n-1, src, dest, helper);
        System.out.println("Transfer Disk "+src+" To "+dest);
        printSteps(n-1, helper, src, dest);
    }

    public static void main(String [] arg){
        printSteps(2, "S", "H", "D");
    }
}