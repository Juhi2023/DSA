import java.util.*;

class SwimingInRisingWater {

    // Backtracking
    //Time Complexity: O(4^N^2)
    // Space Complexity: O(N^2)
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0},{ 0, -1}, {0, 1}};
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dfs(grid, 0, 0, visited, 0, Integer.MAX_VALUE);
    }
    private static int dfs(int[][] grid, int row, int col, boolean[][] visited, int maxHeight, int minTime) {
        int n = grid.length;

        if (row == n - 1 && col == n - 1) {
            return Math.max(maxHeight, grid[row][col]);
        }

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + DIRECTIONS[i][0];
            int newCol = col + DIRECTIONS[i][1];
            
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                int newMaxHeight = Math.max(maxHeight, grid[newRow][newCol]);
                minTime = Math.min(minTime, dfs(grid, newRow, newCol, visited, newMaxHeight, minTime));
            }
        }
        visited[row][col] = false;
        return minTime;
    }


    // DFS
    //Time Complexity: O(N^4)
    // Space Complexity: O(N^2)    
    public int swimInWaterByDFS(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        int minH = grid[0][0], maxH = grid[0][0];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                maxH = Math.max(maxH, grid[row][col]);
                minH = Math.min(minH, grid[row][col]);
            }
        }

        for (int t = minH; t < maxH; t++) {  //ON using binary search here will give T.C: O(N^2 log N)
            if (dfs(grid, visit, 0, 0, t)) {
                return t;
            }
            for (int r = 0; r < n; r++) {
                Arrays.fill(visit[r], false);
            }
        }
        return maxH;
    }

    private boolean dfs(int[][] grid, boolean[][] visit, int r, int c, int t) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid.length || visit[r][c] || grid[r][c] > t) {
            return false;
        }
        if (r == grid.length - 1 && c == grid.length - 1) {
            return true;
        }
        visit[r][c] = true;
        return dfs(grid, visit, r + 1, c, t) ||   dfs(grid, visit, r - 1, c, t) ||  dfs(grid, visit, r, c + 1, t) || dfs(grid, visit, r, c - 1, t);
    }

    //Use Binary Search with above solution

    // Dijkastra Algo
    //Time Complexity: O(N*M) [while loop]  * O(log (N+M)) [Priority operation]
    // Space Complexity: O(N^2)
    public static int swimInWaterByDijkastra(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[2]-b[2]);
        pq.add(new int[]{0, 0, 0});
        visited[0][0]=true;

        while(!pq.isEmpty()){
            int p[]= pq.poll();
            int r = p[0];
            int c = p[1];
            int wt = p[2];

            if(r==n-1 && c==m-1)
                return wt;

            for(int i=0; i<4; i++){
                int x = r + DIRECTIONS[i][0];
                int y = c + DIRECTIONS[i][1];
                if(x>=0 && x<n && y>=0 && y<m && !visited[x][y]){
                    visited[x][y]=true;
                    pq.add(new int[]{x,y, Math.max(grid[x][y], wt)});
                }
            }
        }
        return -1;
    }

    // Dijkastra Algo
    //Time Complexity: O(N*M) [while loop]  * O(4 alpha)
    // Space Complexity: O(N^2)
    public static int swimInWaterByDSU(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);
        List<Integer> positions = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j < n ; j ++)
                positions.add(i * n + j);
        Collections.sort(positions , (a , b) -> grid[a / n][a % n] - grid[b / n][b % n]);
        int dir[][] = new int[][]{{0 , 1} , {0 , -1} , {-1 , 0} , {1 , 0}};
 
        for(int position : positions)
        {
            int r = position / n;
            int c = position % n;
 
            for(int i = 0 ; i < dir.length ; i ++)
            {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
 
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] < grid[r][c])
                    dsu.union(position , nr * n + nc);
            }
 
            if(dsu.findRoot(0) == dsu.findRoot((n * n) - 1))
                return grid[r][c];
        }
 
        return -1;
    }


    public static void main (String[] args) {
        int n = 6;
        int[][] waterLevel = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};

        int ans = swimInWaterByDSU(waterLevel);
        System.out.println(ans);
    }
}

class DSU {
    int parent[];
    int height[];
 
    public DSU(int n) {
        parent = new int[n];
        height = new int[n];
        Arrays.fill(parent , -1);
        Arrays.fill(height , 1);
    }
 
    public int findRoot(int node) {
        if(parent[node] == -1) 
            return node;
        return parent[node] = findRoot(parent[node]);
    }
 
    public boolean union(int node1 , int node2) {
        int ra = findRoot(node1);
        int rb = findRoot(node2);
        if(ra != rb) {
            if(height[ra] < height[rb])
                parent[ra] = rb;
            else if(height[ra] > height[rb])
                parent[rb] = ra;
            else {
                parent[ra] = rb;
                height[rb] ++;
            }
            return true;
        }
        return false;
    }
}