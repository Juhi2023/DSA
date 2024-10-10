import java.util.*;
class SJF{

    public static int getAverageWaitingTime(int[] executionTime) {
        Arrays.sort(executionTime);
        int sum =0 ;
        int t=0;
        int n=executionTime.length;
        for(int i=0; i<n-1; i++){
            t = executionTime[i] + t;
            sum+= t;
        }
        return sum/n;
    }

    public static void main(String[] args) {
        int[] executionTime = {1, 5, 3, 3, 4};
        System.out.println(getAverageWaitingTime(executionTime));
    }
}