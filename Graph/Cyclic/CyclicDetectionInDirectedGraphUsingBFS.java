// Java implementation of the above code
import java.util.*;

public class CyclicDetectionInDirectedGraphUsingBFS {
    //BFS toposort
    //Time Complexity: O(V+E)
    //Space Complexity: O(V)
    public static List<Integer> detectCycle(int V, List<List<Integer>> al) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : al.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args){
        int v = 6;
        List<List<Integer> > al = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<Integer>());
        }
        al.get(5).add(0);
        al.get(5).add(2);
        al.get(4).add(0);
        al.get(2).add(3);
        al.get(3).add(1);
        al.get(4).add(1);

        List<Integer> res = detectCycle(v, al);
        System.out.println(res);
    }
}
