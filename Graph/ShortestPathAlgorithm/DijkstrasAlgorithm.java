import java.util.*;

public class DijkstrasAlgorithm {

    // Time Complexity: O( E log(V) )
    // Space Complexity: O( |E| + |V|)

    public static int[] dijkstra(int V, ArrayList<ArrayList<int[]> > adj, int src){
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)-> x[1]-y[1]);
        pq.add(new int[]{src, 0});
        while(!pq.isEmpty()){
            int point []= pq.poll();
            int node = point[0];

            int weight = point[1];
            for(int x[]: adj.get(node)){
                int v=x[0];
                int wt=x[1];
                if(weight + wt < dist[v]){
                    dist[v] = weight + wt;
                    pq.add(new int[]{v, dist[v]});
                }
            }

        }
        return dist;
    }

    public static int[] getPathByDijkstra(int V, ArrayList<ArrayList<int[]> > adj, int src){
        int dist[] = new int[V];
        int parent[] = new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        parent[src]=-1;
        
        dist[src]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)-> x[1]-y[1]);
        pq.add(new int[]{src, 0});
        while(!pq.isEmpty()){
            int point []= pq.poll();
            int node = point[0];

            int weight = point[1];
            for(int x[]: adj.get(node)){
                int v=x[0];
                int wt=x[1];
                if(weight + wt < dist[v]){
                    dist[v] = weight + wt;
                    pq.add(new int[]{v, dist[v]});
                    parent[v] = node;
                }
            }

        }
        for(int i=0;i<V;i++){
            if (i != src) {
                System.out.print("\n" + src + " -> ");
                System.out.print(i + " \t\t ");
                System.out.print(dist[i] + "\t\t");
                printPath(i, parent);
            }
        }

 

        return dist;
    }

    private static void printPath(int currentVertex, int[] parents){
        if (currentVertex == -1) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }

    public static void main(String[] args){
        ArrayList<ArrayList<int[]> > adj = new ArrayList<>();
        int V = 6;
        int E = 5;
        int[] u = { 0, 0, 1, 2, 4 };
        int[] v = { 3, 5, 4, 5, 5 };
        int[] w = { 9, 4, 4, 10, 3 };

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            adj.get(u[i]).add(new int[]{v[i], w[i]});
            adj.get(v[i]).add(new int[]{u[i], w[i]});
        }

        int[] res= getPathByDijkstra(V,adj,0);
        
        for(int i=0;i<V;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
        
        
    }
}