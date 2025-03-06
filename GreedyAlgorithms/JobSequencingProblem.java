import java.util.*;
class JobSequencingProblem{

    public static int getMaxProfit(int[][] jobs) {
        int sum=0;
        Arrays.sort(jobs, Comparator.comparing(o -> (int)o[2],  Comparator.reverseOrder()));
        int maxDeadline = 0;
        for(int i=0; i<jobs.length; i++){
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }
        int helper[] = new int[maxDeadline];
        Arrays.fill(helper, -1);
        for(int i=0; i<jobs.length; i++){
            int j=jobs[i][1] - 1;
            while(j>=0 && helper[j]!=-1)
                j--;
            if(j>=0){
                helper[j]=jobs[i][0];
                sum+=jobs[i][2];
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        int[][] a = {{1,4,20},{2,1,10},{3,1,40},{4,1,30}};
        System.out.println(getMaxProfit(a));
    }
}