import java.util.*;

class CyclicDetectionInUndirectedGraphUsingBFS {


    //Adjacency List
    //Time Complexity: O(v+ 2*E)
    //Space Complexity: O(3*V)

    static class Node{
        int n;
        int parent;
        public Node(int parent, int n){
            this.parent = parent;
            this.n = n;
        }
    }

    static boolean bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        visited[0] = true;
        q.add(new Node(-1, 0));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (int x : adj.get(curr.n)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(new Node(curr.n, x));
                }else if(curr.parent!=x){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        int V = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(0);
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);

        boolean ans = bfs(adj);
        System.out.print(ans);
    }
}
