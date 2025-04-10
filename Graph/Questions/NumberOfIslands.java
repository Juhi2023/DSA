import java.util.*;
class NumberOfIslands {
    //Time Complexity: O(N*M) (FOR TRAVERSING BOUNDRY) + O(N*M*9) 
    //Space Complexity: O(N*M)


    //Using DFS
    public static void dfs(int row, int col, int n, int m, char[][] grid, boolean visited[][]) {
        int directions[][]={{1,0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1,1}};
        visited[row][col]=true;
        for(int i=0; i<8; i++){
            int x = row + directions[i][0];
            int y = col + directions[i][1];
            if(x>=0 && x< n && y>=0 && y<m && !visited[x][y] && grid[x][y]=='1'){
                dfs(x, y, n, m, grid, visited);
            }
        }
    }

    public static int numIslandsDFS(char[][] grid) {
        int cnt=0;
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        for(boolean x[]: visited)
            Arrays.fill(x, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, n, m, grid, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    //Using BFS
    private static void bfs(int ro, int co, int[][] vis, char[][] grid) {
      vis[ro][co] = 1; 
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[]{ro, co}); 
      int n = grid.length; 
      int m = grid[0].length; 
      
      while(!q.isEmpty()) {
          int row = q.peek()[0]; 
          int col = q.peek()[1]; 
          q.remove(); 
          
          for(int delrow = -1; delrow<=1;delrow++) {
              for(int delcol = -1; delcol <= 1; delcol++) {
                  int nrow = row + delrow; 
                  int ncol = col + delcol; 
                  if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m  && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                      vis[nrow][ncol] = 1; 
                      q.add(new int[]{nrow, ncol}); 
                  }
              }
          }
      }
  }

    public static int numIslands(char[][] grid) {
        int n = grid.length; 
        int m = grid[0].length; 
        int[][] vis = new int[n][m];
        int cnt = 0; 
        for(int row = 0; row < n ; row++) {
            for(int col = 0; col < m ;col++) {
                if(vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++; 
                    bfs(row, col, vis, grid); 
                }
            }
        }
        return cnt; 
    }
    
    public static void main(String[] args){
        char[][] grid =  {
            {'0', '1', '1', '1', '0', '0', '0'},
            {'0', '0', '1', '1', '0', '1', '0'}
        };
                
        System.out.println(numIslands(grid));
    }

}
