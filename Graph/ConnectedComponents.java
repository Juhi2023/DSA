//https://leetcode.com/problems/number-of-provinces/

import java.util.*;

class ConnectedComponets {


    //DFS/BFS
    //Time Complexity: O(v+ 2*E)
    //Space Complexity: O(3*V)
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean visited[], ArrayList<Integer> ans){
        visited[src]=true;
        ans.add(src);
        for(int x: adj.get(src)){
            if(!visited[x])
                dfs(adj, x, visited, ans);
        }
    }

    
    public static ArrayList<ArrayList<Integer>> connectedcomponents(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[n];
        int count=0;
        Arrays.fill(visited, false);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> ans = new ArrayList<>();
            if(!visited[i]){
                dfs(adj, i, visited, ans);
                Collections.sort(ans);
                res.add(ans);
            }       
        }
        return res;
    }

    //Disjoint Union
    //Time Complexity: O(v)
    public static int find(int parent[], int node){
        if(node==parent[node])
            return node;
        return parent[node]=find(parent, parent[node]);
    }

    public static void unionBySize(int parent[], int size[], int a, int b){
        int pa = find(parent, a);
        int pb = find(parent, b);
        if(pa==pb)
            return;
        else if(size[pa]<size[pb]){
            parent[pa] = pb;
            size[pb]+=size[pa];
        }else{
            parent[pb] = pa;
            size[pa]+=size[pb];
        }
    }

    public static int connectedcomponentsByDisjoint(int n, List<List<Integer>> edges) {
        int parent[] = new int[n];
        int size[] = new int[n];
        Arrays.fill(size, 0);
        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        for(List<Integer> e: edges){
            unionBySize(parent, size, e.get(0), e.get(1));
        }

        int count=0;
        for(int i=0; i<n; i++){
            if(parent[i]==i){
                count++;
            }
        }
        return count;
        
    }

    public static void main(String[] args) {
        
        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));       
        adj.add(new ArrayList<>(Arrays.asList(0)));       
        adj.add(new ArrayList<>(Arrays.asList(0)));          
        adj.add(new ArrayList<>(Arrays.asList()));          
    
        System.out.println(connectedcomponents(5, adj));

        List<List<Integer>> edges = new ArrayList<>();
		edges.add(Arrays.asList(0, 1));
		edges.add(Arrays.asList(2, 1));
		edges.add(Arrays.asList(3, 4));
		edges.add(Arrays.asList(2, 5));

        System.out.print(connectedcomponentsByDisjoint(6, edges));

    }
}
