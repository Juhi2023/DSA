import java.util.*;
class ConnectNRopesWithMinimalCost {

    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x: arr){
            pq.offer(x);
        }
        int sum=0;
        while(pq.size()>1){
            int prev=pq.poll() + pq.poll();
            sum+=prev;
            pq.add(prev);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] points = {4, 2, 7, 6, 9};

        System.out.println(minCost(points));
    }
}