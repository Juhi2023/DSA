import java.util.*;

class TopoSortUsingDFS {
    //Time Complexity: O(V+E)
    //Space Complexity: O(2V)
    static boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        int cnt=0;
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
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            for (int x : adj.get(node)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        if(cnt==V)
            return false;
        return true;
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

        boolean ans = topoSort(V, adj);
        System.out.println(ans);
    }
}
 