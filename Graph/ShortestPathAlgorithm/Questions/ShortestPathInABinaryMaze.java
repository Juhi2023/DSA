import java.util.*;

class ShortestPathInABinaryMaze {
    // Time Complexity: O( 4 * N * M)
    // Space Complexity: O(N * M)

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) 
            return -1;
        if(n==1 && m==1)
            return 1;

        int dir[][] = {{0,1}, {0, -1}, {-1, 0}, {1, 0}, {1,-1},{-1, 1}, {1,1}, {-1, -1}};
        int[][] dis = new int[n][m];

        for(int[] row : dis){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1});
        dis[0][0] = 1;

        while(!q.isEmpty()){
            int [] p = q.poll();
            int row = p[0];
            int col = p[1];
            int distance = p[2];
                
            for(int i=0; i<8; i++){
                int x = row + dir[i][0];
                int y = col + dir[i][1];

                if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0 && distance + 1 < dis[x][y]){
                    if(x == n-1 &&  y == m-1) 
                        return distance + 1; 
                    dis[x][y] = distance + 1;
                    q.add(new int[]{x, y, dis[x][y]});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
       
        int[] source={0,1};
        int[] destination={2,2};
        
        int[][] grid={{0, 1, 1, 1},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 1},
            {0, 1, 0, 0}};

        int res = shortestPathBinaryMatrix(grid);
        
        System.out.print(res);
        System.out.println();
    }
}