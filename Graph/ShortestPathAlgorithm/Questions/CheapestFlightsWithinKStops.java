import java.util.*;
class CheapestFlightsWithinKStops {
    // Time Complexity: O( E )
    // Space Complexity: O( |E| + |V|)

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length ; i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{src, 0});
        int stops=0;
        while(!pq.isEmpty() && stops<=k){
            int size = pq.size();
            for(int i=0; i<size; i++){
                int[]curr= pq.poll();
                int node = curr[0];
                int distance = curr[1];

                for(int j=0; j<adj.get(node).size(); j++){
                    int x[] = adj.get(node).get(j);
                    int v=x[0];
                    int wt=x[1];
                    if(wt+distance < dist[v]){
                        dist[v] = wt+distance;
                        pq.add(new int[]{v, dist[v]});
                    }
                }   
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }

    public static int findCheapestPriceOtherWay(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length ; i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> pq = new LinkedList<>();
        //stop  -  node  - distance
        pq.offer(new int[]{0, src, 0});

        while(!pq.isEmpty()){
            int[]curr= pq.poll();
            int stops=curr[0];
            int node = curr[1];
            int distance = curr[2];
            if(stops > k) continue; 
            for(int j=0; j<adj.get(node).size(); j++){
                int x[] = adj.get(node).get(j);
                int v=x[0];
                int wt=x[1];
                if(wt+distance < dist[v] && stops <= k){
                    dist[v] = wt+distance;
                    pq.add(new int[]{stops+1, v, dist[v]});
                }
            }   

        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }

    public static void main(String[] args) {
       
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        int ans = findCheapestPrice(n,flights,src,dst,K);
        
        System.out.print(ans);
        System.out.println();
    }
}