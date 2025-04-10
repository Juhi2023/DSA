import java.util.*;

public class GraphValidTree {

    public static boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        if (n == 1 && edges.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }

        if (edges.length != n - 1) {
            return false;
        }

        return true;
    }

    private static boolean dfs(int node, int parent, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (!dfs(neighbor, node, graph, visited)) {
                    return false;
                }
            } else if (neighbor != parent) {  // Cycle detected
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(n1, edges1));

    }
}
