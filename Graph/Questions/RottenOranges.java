import java.util.*;

class RottonOranges{

    //Time Complexity: O(T*N*M)
    public static int rottenOrangesBrute(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int time = 0;
        boolean changed = false;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        
        while (true) {
            changed = false;
            
            // Create a temporary grid to mark newly rotten oranges
            int[][] temp = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    temp[i][j] = grid[i][j];
                }
            }
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 2) {
                        for(int k=0; k<4; k++){
                            int x = i + directions[k][0];
                            int y = j + directions[k][1];
                            if(x>=0 && y>=0 && x< rows && y<cols && grid[x][y]==1){
                                temp[x][y]=2;
                                changed=true;
                            }
                        }
                    }
                }
            }
            
            // Update the grid
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = temp[i][j];
                }
            }
            
            if (!changed) {
                break;
            }
            time++;
        }
        
        // Check if there are any fresh oranges left
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return time;
    }
    
    // DFS
    //Time Complexity: O(N*M)
    //Space Complexity: O(N*M)
    public static int maxTime = 0;
    public static boolean isSafe(int oranges[][], int row, int col, int n, int m){
        return (row>=0 && row<n) && (col>=0 && col<m) && oranges[row][col]==1;
    }
    
    public static void DFS(int oranges[][], int row, int col, int n, int m, int time){
        maxTime = Math.max(maxTime, time);
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        oranges[row][col]=2;
    
        for (int k = 0; k < 4; k++){
            int x = row + directions[k][0];
            int y = col + directions[k][1];
            if (isSafe(oranges, x, y, n, m) ){
                oranges[x][y]=2;
                DFS(oranges, x, y, n, m, time+1);
            }
        }


    }
    
    public static int rottenOrangesDFS(int oranges[][], int n){
        int m = oranges[0].length;
    
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (oranges[i][j]==2){
                    DFS(oranges, i, j, n, m, 0);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (oranges[i][j] == 1) {
                    return -1;  // Impossible to rot all oranges
                }
            }
        }
        return maxTime;
    }

    // BFS
    //Time Complexity: O(N*M)
    //Space Complexity: O(N*M)
    public static int rottenOrangesBFS(int oranges[][], int n){
        if(oranges == null || n == 0) return 0;
        int rows = n;
        int cols = oranges[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;

        //Put the position of all rotten oranges in queue and count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(oranges[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                if(oranges[i][j] != 0) {
                    count_fresh++;
                }
            }
        }
       
        if(count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt += size; 
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int j = 0;j<4;j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x < 0 || y < 0 || x >= rows || y >= cols || oranges[x][y] == 0 || oranges[x][y] == 2) continue;
                    
                    oranges[x][y] = 2;
                    queue.offer(new int[]{x , y});
                }
            }
            if(queue.size() != 0) {
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1;
    }
    public static void main(String[] args) {
        int[][] oranges = { { 1, 1, 1 },
                        { 1, 1, 1 },
                        { 1, 1, 2 } };
        
        int result = rottenOrangesDFS(oranges, 3);
        System.out.println("Minimum time to rot all oranges: " + result);
    }
}