//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description
 
import java.util.*;

class TotalCosttToHireKWorkers {
    public static long totalCost(Integer[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> headW = new PriorityQueue<>();
        PriorityQueue<Integer> tailW = new PriorityQueue<>();
        
        int nextHead = 0;
        int nextTail = n - 1;

        for (int i = 0; i < candidates && nextHead <= nextTail; i++) {
            headW.add(costs[nextHead++]);
        }

        for (int i = 0; i < candidates && nextHead <= nextTail; i++) {
            tailW.add(costs[nextTail--]);
        }

        
        long ans=0;

        for (int i = 0; i < k; i++) {
            if(tailW.isEmpty() || !headW.isEmpty() && headW.peek() <= tailW.peek()){
                ans+= headW.poll();
                if (nextHead <= nextTail) {
                    headW.add(costs[nextHead]);
                    nextHead++;
                }
            }else{
                ans+= tailW.poll();
                if (nextHead <= nextTail) {
                    tailW.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int K = 3;
        Integer costs[] = {17,12,10,2,7,2,11,20,8};
        System.out.print(totalCost(costs, K, 4));
    }
}