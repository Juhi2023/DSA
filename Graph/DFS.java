import java.util.*;

class DFS {


    //Adjacency List
    //Time Complexity: O(v+ 2*E)
    //Space Complexity: O(3*V)
    static void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean visited[], ArrayList<Integer> res) {
        res.add(src);
        visited[src]=true;

        for (int x : adj.get(src)) {
            if (!visited[x]) {
                dfs(x, adj, visited, res);
            }
        }
    }

    static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        visited[0] = true;
        dfs(0, adj, visited, res);
        return res;
    }

    static ArrayList<Integer> dfsOfGraphIterative(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
            
        while(stack.empty() == false){
            int s = stack.peek();
            stack.pop();
            
            if(visited[s] == false){
                res.add(s);
                visited[s] =true;
            }

            for (int x : adj.get(s)) {
                if (!visited[x]) {
                    stack.push(x);
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
        
        ArrayList<Integer> ans = dfsOfGraphIterative(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
