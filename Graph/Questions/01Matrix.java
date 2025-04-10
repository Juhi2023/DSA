//https://leetcode.com/problems/01-matrix/description/
//https://leetcode.com/problems/map-of-highest-peak/description/
import java.util.*;

class Zero1Matrix
{
    // BFS
    //Time Complexity: O(N*M)
    //Space Complexity: O(N*M)
    public static int[][] findNearest0ByVisistedArray(int[][] grid){
        int n = grid.length; 
	    int m = grid[0].length; 
	    int vis[][] = new int[n][m]; 
	    int dist[][] = new int[n][m]; 
	    Queue<int[]> q = new LinkedList<>();
	    for(int i = 0;i<n;i++) {
	        for(int j = 0;j<m;j++) {
	            if(grid[i][j] == 0) {
	                q.add(new int[]{i, j, 0}); 
	                vis[i][j] = 1; 
	            }
	            else {
	                vis[i][j] = 0; 
	            }
	        }
	    }
	    
	    int directions[][]= {{1,0}, {-1,0}, {0,1}, {0, -1}};
 
	    
	    
	    while(!q.isEmpty()) {
	        int temp[] = q.poll();
            int row=temp[0];
            int col=temp[1];
            int steps=temp[2];
	        dist[row][col] = steps; 
	        for(int i = 0;i<4;i++) {
	            int nrow = row + directions[i][0]; 
	            int ncol = col + directions[i][1]; 
	            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0)  {
	                vis[nrow][ncol] = 1; 
    	            q.add(new int[]{nrow, ncol, steps+1});  
	            } 
	        }
	    }
	    
	    return dist; 
    }

    // BFS
    //Time Complexity: O(N*M)
    //Space Complexity: O(N*M)
    public static int[][] findNearest0WithoutVisistedArray(int[][] mat) {
        int n= mat.length;
        int m=mat[0].length;
        int ans[][] =new int[n][m];
        for(int x[]: ans){
            Arrays.fill(x, 0);
        }
        int directions[][]= {{1,0}, {-1,0}, {0,1}, {0, -1}};

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i, j, 0});
                } 
            }
        }

        while(!q.isEmpty()){
            int temp[] = q.poll();
            int row=temp[0];
            int col=temp[1];
            int step=temp[2];

            for(int i=0; i<4; i++){
                int x = row+directions[i][0];
                int y = col+directions[i][1];
                if(x>=0 && x<n && y>=0 && y<m && ans[x][y]==0 && mat[x][y]==1){
                    ans[x][y]=step+1;
                    q.add(new int[]{x, y, step+1});
                }
            }
        }
        return ans;
    }

    
    public static void main(String[] args){
        int[][] grid = {
            {0,1,1,0},
            {1,1,0,0},
            {0,0,1,1}
        };

        int[][] ans = findNearest0ByVisistedArray(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " "); 
            }
            System.out.println();
        }
    }
}