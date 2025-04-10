import java.util.*;

class CyclicDetectionInDirectedGraphUsingDFS {


    //Adjacency List
    //Time Complexity: O(v+ 2*E)
    //Space Complexity: O(3*V)
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean visited [], boolean pathVisited [], int i) {
        visited[i]=true;
        pathVisited[i]=true;
        for(int x: adj.get(i)){
            if(!visited[x]){
                if(dfs(adj, visited, pathVisited, x))
                    return true;
            }else if(pathVisited[x]){
                return true;
            }
        }
        pathVisited[i]=false;
        return false;
    }
    
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean visited []= new boolean[adj.size()];
        boolean pathVisited []= new boolean[adj.size()];
        Arrays.fill(visited, false);
        Arrays.fill(pathVisited, false);

        for(int i=0; i< adj.size(); i++){
            if(!visited[i])
                if(dfs(adj, visited, pathVisited, i))
                    return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
      
        
        boolean ans = isCycle(adj);
        System.out.print(ans);
    }
}
