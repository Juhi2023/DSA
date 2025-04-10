import java.util.*;

class BFS {


    //Adjacency List
    //Time Complexity: O(v+ 2*E)
    //Space Complexity: O(3*V)

    static ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        visited[0] = true;
        q.add(0);
        
        while (!q.isEmpty()) {
            
            int curr = q.poll();
            res.add(curr);
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        
        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));       
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));       
        adj.add(new ArrayList<>(Arrays.asList(0)));          
        adj.add(new ArrayList<>(Arrays.asList(2)));          
        
        ArrayList<Integer> ans = bfsOfGraph(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
