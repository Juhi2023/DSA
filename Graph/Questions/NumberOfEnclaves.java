import java.util.*;

class NumberOfEnclaves {
    //Time Complexity: O(N) + O(M) (FOR TRAVERSING BOUNDRY) + O(NxMx4) 
    //Space Complexity: O(N*M)

    //Using BFS
     int numberOfEnclavesBFS(int[][] grid) {
        Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length; 
        int m = grid[0].length; 
        int vis[][] = new int[n][m];
        // traverse boundary elements
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {

                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    if(grid[i][j] == 1) {
                        q.add(new Pair(i, j)); 
                        vis[i][j] = 1; 
                    }
                }
            }
        }
        
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1}; 
        
        while(!q.isEmpty()) {
            int row = q.peek().first; 
            int col = q.peek().second; 
            q.remove(); 
            
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i]; 
                if(nrow >=0 && nrow <n && ncol >=0 && ncol < m 
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1; 
                }
            }
            
        }
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(grid[i][j] == 1 & vis[i][j] == 0) 
                    cnt++; 
            }
        }
        return cnt; 
        
    }

    //Using DFS
    public static void dfs(int row, int col, int n, int m, int[][] grid) {
        int directions[][]={{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        grid[row][col]=0;
        for(int i=0; i<4; i++){
            int x = row + directions[i][0];
            int y = col + directions[i][1];
            if(x>=0 && x< n && y>=0 && y<m && grid[x][y]==1){
                dfs(x, y, n, m, grid);
            }
        }
    }
    public static int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n-1 || j == m-1) && grid[i][j] == 1) {
                    dfs(i, j, n, m, grid);
                }
            }
        }

        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s += grid[i][j];
            }
        }
        return s;
    }
    
    public static void main(String[] args){
        int grid[][] = {
        {0, 0, 0, 0},
        {1, 0, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0}};

        int ans =numberOfEnclaves(grid);
        System.out.println(ans);
    }

}
