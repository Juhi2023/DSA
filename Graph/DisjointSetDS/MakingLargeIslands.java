import java.util.*;


class MakingLargeIslands {
    //DSU
    //Time Complexity: O(N * N *(N*N))
    //Space Complexity: O(N*N) 
    public static int MaxConnectionByDSU(int n, int[][] grid) {
        DSU  ds = new DSU(n*n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                   int dir[][] = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
                   for(int k=0; k<4; k++){
                        int x = i+dir[k][0];
                        int y = j+dir[k][1];
                        if(x>=0 && x<n && y>=0 &&y<n && grid[x][y]==1){
                            int a=i*n+j;
                            int b=x*n+y;
                            if(ds.find(a)!=ds.find(b)){
                                ds.union(a, b);
                            }
                        }
                   }
                }
            }
        }

        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                   int dir[][] = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
                   HashSet<Integer> set = new HashSet<>();
                   for(int k=0; k<4; k++){
                        int x = i+dir[k][0];
                        int y = j+dir[k][1];
                        if(x>=0 && x<n && y>=0 &&y<n && grid[x][y]==1){
                            int a=x*n+y;
                            set.add(ds.find(a));
                        }
                   }
                    int sum =0;
                   for(Integer x: set){
                        sum+= ds.size[x];
                   }
                   ans = Math.max(ans, sum+1);
                }
            }
        }
        return ans==0 ? n*n : ans;
    }

    //DFS !IMP Solution should how to impement usng DFS
    //Time Complexity: O(N * N *(N*N))
    //Space Complexity: O(N*N) 
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int MaxConnection(int n, int[][] grid) {
        List<Integer> key = new ArrayList<>();
        int id = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, id);
                    key.add(size);
                    id++;
                }
            }
        }

        if (key.isEmpty()) return 1;

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int sum = 1;
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] >= 2) {
                            int islandId = grid[ni][nj];
                            if (!seen.contains(islandId)) {
                                sum += key.get(islandId - 2);
                                seen.add(islandId);
                            }
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
        }

        return max == 0 ? n * n : max;
    }

    private static int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = id;
        int count = 1;
        for (int[] dir : dirs) {
            count += dfs(grid, i + dir[0], j + dir[1], id);
        }
        return count;
    }
    

    public static void main (String[] args) {
        int n = 4, m = 5;
        int[][] grid = {
            {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };
        System.out.println(MaxConnection(4, grid));
    }
}

class DSU{
    int parent[];
    int size[];
    public DSU(int n){
        parent= new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i]=1;
        }
    }

    public int find(int node){
        if(node==parent[node])
        return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int a, int b){
        int pa = find(a);
        int pb= find(b);
        if(pa==pb)
            return;
        else if(pa>pb){
            parent[pb]=pa;
            size[pa]+=size[pb];
        }else{
            parent[pa]=pb;
            size[pb]+=size[pa];
        }
    }
}
