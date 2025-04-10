import java.util.*;

class CyclicDetectionInUndirectedGraphUsingDFS {


    //Adjacency List
    //Time Complexity: O(v+ 2*E)
    //Space Complexity: O(3*V)
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean visited [], int parent, int i) {
        visited[i]=true;
        for(int x: adj.get(i)){
            if(!visited[x]){
                if(dfs(adj, visited, i, x))
                    return true;
            }else if(parent!=x)
                return true;
        }
        return false;
    }
    
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean visited []= new boolean[adj.size()];
        Arrays.fill(visited, false);
        for(int i=0; i< adj.size(); i++){
            if(!visited[i])
                if(dfs(adj, visited, -1, i))
                    return true;
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
      
        
        boolean ans = isCycle(adj);
        System.out.print(ans);
    }
}
