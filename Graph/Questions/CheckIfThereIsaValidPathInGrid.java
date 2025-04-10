import java.util.*;
class CheckIfThereIsaValidPathInGrid {
    public static boolean hasValidPath(int[][] grid) {
        int[][][] dir = {
            {{0, 1}, {0, -1}}, 
            {{1, 0}, {-1, 0}}, 
            {{0, -1}, {1, 0}}, 
            {{0, 1}, {1, 0}},  
            {{-1, 0}, {0, -1}},
            {{-1, 0}, {0, 1}}  
        };
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][] = new boolean[n][m];
        visited[0][0]=true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int []p = q.poll();
            int row = p[0];
            int col = p[1];
            int num = grid[row][col]-1;
            for(int temp[]: dir[num]){
                int x = row+ temp[0];
                int y = col+ temp[1];

                if(x>=0 && y>=0 && x<n && y<m && !visited[x][y]){
                    for(int backTemp[]: dir[grid[x][y]-1]){
                        if(backTemp[0]+x == row && backTemp[1]+y == col){
                            visited[x][y]=true;
                            q.offer(new int[]{x, y});
                        }

                    }
                }
            }
        }
        return visited[n-1][m-1];

    }

    public static void main(String[] args) {

        int grid[][]= {{2,4,3},{6,5,2}};
        boolean ans = hasValidPath(grid);

        System.out.print(ans);
        System.out.println();
    }
}