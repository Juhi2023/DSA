import java.util.*;
class NumberOfWaysToArriveAtDestination {

    public static int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int x[] : roads){
            adj.get(x[0]).add(new int[]{x[1], x[2]});
            adj.get(x[1]).add(new int[]{x[0], x[2]});
        }

        int mod = (int)(1e9+7);
        long dist[]= new long[n];
        int ways[]= new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0]=0;
        ways[0]=1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0});
        while(!pq.isEmpty()){
            long[]p = pq.poll();
            long node = p[0];
            long weight = p[1];

            for(int x[]: adj.get((int)node)){
                int v=x[0];
                int wt=x[1];

                if(weight+wt<dist[v]){
                    dist[v] = weight+wt;
                    pq.add(new long[]{v, dist[v]});
                    ways[v] = ways[(int)node];
                }else if(weight+wt == dist[v]){
                    ways[v] = (ways[(int)node] + ways[v])% mod;
                }
            }
        }
        return ways[n-1]% mod;
    }

    public static void main(String[] args) {

        int n = 7;
        int roads[][] = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        
        int ans = countPaths(n, roads);

        System.out.print(ans);
        System.out.println();
    }
}

