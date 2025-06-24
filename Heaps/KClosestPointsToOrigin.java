import java.util.*;
class KClosestPointsToOrigin {
    
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    public static double dist(int a, int b){
        return Math.sqrt(Math.pow(a, 2)+ Math.pow(b, 2));
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> Double.compare(dist(a[0], a[1]), dist(b[0], b[1])));
        for(int i=0; i<points.length; i++){
            pq.add(new int[]{points[i][0], points[i][1]});
        }
        int ans[][] = new int[k][2];
        for(int i=0; i<k; i++){
            ans[i]=pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        int[][] closest = kClosest(points, k);
        for (int[] point : closest) {
            System.out.println(Arrays.toString(point));
        }
    }
}