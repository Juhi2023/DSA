import java.io.*;
import java.util.*;

class MostStonesRemovedWithSameRowColumn {

    //DFS
    //Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public static void dfs(int i, int j, int ind, boolean visited[], int n, int stones[][]) {
        visited[ind]=true;
        for(int k=0; k<n; k++){
            if(!visited[k] && (stones[k][0]==i || stones[k][1]==j)){
                dfs(stones[k][0], stones[k][1], k, visited, n, stones);
            }
        }
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        boolean visited[] = new boolean[n];
        int ans=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(stones[i][0], stones[i][1], i, visited, n, stones);
                ans++;
            }
        }
        return n-ans;
    }

    // Disjoint set
    //Time Complexity: O(n * α(n))
    // Space Complexity: O(N)

    public static int removeStonesByDisjointSet(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int stone[] : stones)
            set.add(ds.findUPar(stone[0]));
 
        int comps = set.size();
        return n - comps;
    }

    public static void main (String[] args) {
        int n = 6;
        int[][] stones = {
            {0, 0}, {0, 2},
            {1, 3}, {3, 1},
            {3, 2}, {4, 3}
        };

        int ans = removeStonesByDisjointSet(stones);
        System.out.println("The maximum number of stones we can remove is: " + ans);
    }
}


class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}


//Another way using disjoint set
class UnionFind {
    int[] parent;
    int componentCount;
    Set<Integer> uniqueNodes;

    UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
        componentCount = 0;
        uniqueNodes = new HashSet<>();
    }

    int find(int node) {
        if (!uniqueNodes.contains(node)) {
            componentCount++;
            uniqueNodes.add(node);
        }

        if (parent[node] == -1) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return;
        }

        parent[root1] = root2;
        componentCount--;
    }
}
