import java.util.*;

public class CompleteConnectedComponents {

    //BFS
    //Time Complexity: O(V+E)
    //Space Complexity: O(V+E)
    public int countCompleteComponentsBFS(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                // BFS to find all vertices in the current component
                List<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(vertex);
                visited[vertex] = true;

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    component.add(current);

                    for (int neighbor : graph.get(current)) {
                        if (!visited[neighbor]) {
                            queue.add(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }

                boolean isComplete = true;
                for (int node : component) {
                    if (graph.get(node).size() != component.size() - 1) {
                        isComplete = false;
                        break;
                    }
                }

                if (isComplete) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    //DFS
    //Time Complexity: O(V+E)
    //Space Complexity: O(V+E)
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean visited[], int vertex[], int edge[]){
        visited[src]=true;
        vertex[0]++;
        edge[0]+= adj.get(src).size();
        for(int x: adj.get(src)){
            if(!visited[x])
                dfs(adj, x, visited, vertex, edge);
        }
    }

    public static int countCompleteComponents(int n, ArrayList<ArrayList<Integer>> adj) {
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for(int i=0; i<n; i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int i=0; i<edges.length; i++){
        //     adj.get(edges[i][1]).add(edges[i][0]);
        //     adj.get(edges[i][0]).add(edges[i][1]);
        // }

        boolean visited[] = new boolean[n];
        int count=0;
        Arrays.fill(visited, false);
        for(int i=0; i<n; i++){
            int vertex[]={0};
            int edge[]={0};
            if(!visited[i]){
                dfs(adj, i, visited, vertex, edge);
                if((vertex[0]*(vertex[0]-1)/2) == edge[0]/2)
                    count++;
            }       
        }
        return count;
    }

    public static void main(String[] args)
    {

        int V = 7;
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>(V + 1);

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(1).add(2);
        adj.get(7).add(2);
        adj.get(3).add(5);
        adj.get(3).add(4);
        adj.get(4).add(5);

        int numberOfGoodComponents = countCompleteComponents(V, adj);

        System.out.println(numberOfGoodComponents);
    }
}
