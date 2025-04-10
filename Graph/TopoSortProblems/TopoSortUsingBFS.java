import java.util.*;

class TopoSortUsingBFS {
    //Time Complexity: O(V+E)
    //Space Complexity: O(2V)
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        int ans[] = new int[V];
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            for (int x: adj.get(i)) {
                indegree[x]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if(indegree[i]==0)
                q.offer(i);
        }
        int k=0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[k++] = node;
            for (int x : adj.get(node)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
 