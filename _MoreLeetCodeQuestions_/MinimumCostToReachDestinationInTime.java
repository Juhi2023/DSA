//https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/description/
class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a, b)-> a[2]-b[2]);
        List<List<int[]>> adj = new ArrayList<>();
        int V = passingFees.length;
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
        int dist[]= new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{ 0, 0, passingFees[0]});
        dist[0]=0;
        while(!pq.isEmpty()){
            int p [] = pq.poll();
            int wt = p[0];
            int u = p[1];
            int currFees = p[2];
            if(u==V-1){
                return currFees;
            }

            for(int x[]: adj.get(u)){
                int v=x[0];
                int weight=x[1];
                if(wt+weight > maxTime)
                    continue;
                if(weight + wt < dist[v]){
                    dist[v] = weight + wt;
                    pq.add(new int[]{dist[v], v, currFees + passingFees[v]});
                }
            }
        }
        return -1;
    }
}