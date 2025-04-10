import java.util.*;
class NumberOfDistinctIslands {

    //Time Complexity: O(N*M*log(N*M)) (FOR TRAVERSING BOUNDRY) + O(N*M*4) 
    //Space Complexity: O(N*M)
    public static void dfs(int row, int col, int n, int m, int[][] grid, boolean visited[][], int rowBase, int colBase, HashSet<ArrayList<String>> st, ArrayList<String> points ) {
        int directions[][]={{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        visited[row][col]=true;
        points.add((row-rowBase) + " " + (col-colBase));
        for(int i=0; i<4; i++){
            int x = row + directions[i][0];
            int y = col + directions[i][1];
            if(x>=0 && x< n && y>=0 && y<m && !visited[x][y] && grid[x][y]==1){
                dfs(x, y, n, m, grid, visited, rowBase, colBase, st, points);
            }
        }
    }

    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for(boolean x[]: visited)
            Arrays.fill(x, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ArrayList<String> points = new ArrayList<>();
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(i, j, n, m, grid, visited, i, j, st, points);
                    st.add(points);
                }
            }
        }

        return st.size();
    }

    public static void main(String[] args) {
     int grid[][] = {
        {1, 1, 0, 1, 1},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {1, 1, 0, 1, 1}};

    int ans = countDistinctIslands(grid);
    System.out.println(ans);
  }

}
