import java.util.*;

class HasPath {


    //Adjacency List
    //Time Complexity: O(v+ 2*E)
    //Space Complexity: O(3*V)
    static boolean hasPath(ArrayList<ArrayList<Integer>> adj, int src, int des) {
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();
        stack.push(src);

        while(stack.empty() == false){
            int s = stack.pop();
            
            if(s==des){
                return true;
            }

            for (int x : adj.get(s)) {
                if (!visited[x]) {
                    visited[x]=true;
                    stack.push(x);
                }
            }
        }

        return false;
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
        
        System.out.print( hasPath(adj, 3, 2));
    }
}
