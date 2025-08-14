//https://leetcode.com/problems/min-cost-to-connect-all-points/ 

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        boolean visited[]= new boolean[V];
        Arrays.fill(visited, false);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0,0});

        int sum=0;
        while(!pq.isEmpty()){
            int p[]= pq.poll();
            int wt = p[0];
            int u = p[1];

            if(!visited[u]){
                visited[u]=true;
                sum += wt;

                for(int i=0; i<V; i++){
                    int dist = Math.abs(points[u][0] - points[i][0]) + Math.abs(points[u][1] - points[i][1]);
                    if(!visited[i]){
                        pq.offer(new int[]{dist, i});
                    }
                }
            }
        }

        return sum;
    }
}