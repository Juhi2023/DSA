import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPathInDAG {

    //Time Complexity: O(V+2E)
    //Space Complexity: O(V)
   private static void topoSort(int node, ArrayList < ArrayList < int[] >> adj, int vis[], Stack < Integer > st) { 
    vis[node] = 1;
    for (int i = 0; i < adj.get(node).size(); i++) {
      int v = adj.get(node).get(i)[0];
      if (vis[v] == 0) {
        topoSort(v, adj, vis, st);
      }
    }
    st.add(node);
  }

  public static int[] shortestPath(int N, int M, int[][] edges, int src) {
    ArrayList < ArrayList < int[] >> adj = new ArrayList < > ();
    for (int i = 0; i < N; i++) {
      ArrayList < int[] > temp = new ArrayList <> ();
      adj.add(temp);
    }

    for (int i = 0; i < M; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int wt = edges[i][2];
      adj.get(u).add(new int[]{v, wt});
    }

    int vis[] = new int[N];
    Stack < Integer > st = new Stack < > ();
    for (int i = 0; i < N; i++) {
      if (vis[i] == 0) {
        topoSort(i, adj, vis, st);
      }
    }

    System.out.println(st);

    int dist[] = new int[N];
    for (int i = 0; i < N; i++) {
      dist[i] = (int)(1e9);
    }

    dist[src] = 0;
    while (!st.isEmpty()) {
      int node = st.peek();
      st.pop();

      for (int i = 0; i < adj.get(node).size(); i++) {
        int v = adj.get(node).get(i)[0];
        int wt = adj.get(node).get(i)[1];

        if (dist[node] + wt < dist[v]) {
          dist[v] = wt + dist[node];
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (dist[i] == 1e9) dist[i] = -1;
    }
    return dist;
  }

  public static void main(String[] args) {
    int n = 6, m = 7;
    int[][] edge = {{0,1,2},{4,0,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
    int res[] = shortestPath(n, m, edge, 0);
    for (int i = 0; i < n; i++) {
      System.out.print(res[i] + " ");
    }
    System.out.println();
  }
}