import java.util.*;

class PrismAlgorithm {
    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean visited[]= new boolean[V];
        Arrays.fill(visited, false);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0,0, -1});

        int sum=0;
        List<List<Integer>> edges= new ArrayList<>();
        while(!pq.isEmpty()){
            int p[]= pq.poll();
            int wt = p[0];
            int u = p[1];
            int v = p[2];

            if(!visited[u]){
                visited[u]=true;
                sum += wt;
                if(v!=-1){
                    List<Integer> temp= new ArrayList<>();
                    temp.add(v);
                    temp.add(u);
                    edges.add(temp);
                }

                for(int x[] : adj.get(u)){
                    if(!visited[x[0]]){
                        pq.offer(new int[]{x[1], x[0], u});
                    }
                }
            }
        }
        System.out.println(edges);

        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<int[]>> adj = new ArrayList<>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];


            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int sum = spanningTree(V, 6, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }
}