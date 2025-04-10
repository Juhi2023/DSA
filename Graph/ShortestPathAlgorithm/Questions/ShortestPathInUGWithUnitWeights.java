import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPathInUGWithUnitWeights{

    //BFS
    //Time Complexity: O(V+2E)
    //Space Complexity: O(V)
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]); 
            adj.get(edges[i][1]).add(edges[i][0]); 
        }
        int dist[] = new int[n];
        for(int i = 0;i<n;i++) 
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0; 

        Queue<Integer> q = new LinkedList<>();
        q.add(src); 
        while(!q.isEmpty()) {
            int node = q.peek(); 
            q.remove(); 
            for(int it : adj.get(node)) {
                if(dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node]; 
                    q.add(it); 
                }
            }
        }
        for(int i = 0;i<n;i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1; 
            }
        }
        return dist; 
    }

    

    //DFS
    //Time Complexity: O(V+E)
    //Space Complexity: O(3V)
    // public static void dfs(ArrayList<ArrayList<Integer>> graph, int node, int[] distance, boolean[] visited, int currentDist) {
    //     visited[node] = true;
    //     distance[node] = Math.min(distance[node], currentDist);
        
    //     for (int neighbor : graph.get(node)) {
    //         if (!visited[neighbor]) {
    //             dfs(graph, neighbor, distance, visited, currentDist + 1);
    //         }
    //     }
    //     visited[node] = false;
    // }
    // public static int[] shortestPathDFS(ArrayList<ArrayList<Integer>> graph, int n, int src) {
    //     boolean[] visited = new boolean[n];
    //     int[] distance = new int[n];
    //     Arrays.fill(distance, Integer.MAX_VALUE);
    //     distance[src] = 0;

    //     dfs(graph, 0, distance, visited, 0);
    //     return distance;
    // }

    
    public static void main(String[] args) {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
          
    
        int res[] = shortestPath(edge, n,m, 0);

        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
