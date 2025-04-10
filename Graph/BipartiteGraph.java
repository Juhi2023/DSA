import java.util.*;
class BipartiteGraph {

    //Adjacency List
    //Time Complexity: O(v+ 2*E)
    //Space Complexity: O(3*V)
    public static boolean dfs(int node, int[][] graph, int color[], int currColor){
        color[node] = currColor;
        for(int x: graph[node]){
            if(color[x]==0){
                if(!dfs(x, graph, color, currColor==1 ? 2: 1))
                    return false;
            }else if(color[x]==currColor){
                return false;
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int [n];
        Arrays.fill(color, 0);

        for(int i=0; i<n; i++){
            if(color[i]==0){
                if(dfs(i, graph, color, 1)==false)
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
         int[][] list = new int[4][];
        
        list[0] = new int[]{1, 2, 3};     
        list[1] = new int[]{0, 2};        
        list[2] = new int[]{0, 1, 3}; 
        list[3] = new int[]{0, 2}; 
        System.out.println(isBipartite(list));
    }
}