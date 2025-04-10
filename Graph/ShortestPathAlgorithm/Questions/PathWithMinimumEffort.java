import java.util.*;
class PathWithMinimumEffort {
    // Time Complexity: O( 4 * N * M * * log( N*M))  additional log(N*M) for insertion-deletion operations in a priority queue 
    // Space Complexity: O(N * M)
    public static int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;

        if(n==1 && m==1)
            return 0;

        int dir[][] = {{0,1}, {0, -1}, {-1, 0}, {1, 0}};
        int[][] dist = new int[n][m];

        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[2]-b[2]);

        q.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while(!q.isEmpty()){
            int [] p = q.poll();
            int row = p[0];
            int col = p[1];
            int diff = p[2];
            if(row == n-1 &&  col == m-1) 
                return diff; 
                
            for(int i=0; i<4; i++){
                int x = row + dir[i][0];
                int y = col + dir[i][1];

                if(x >= 0 && x < n && y >= 0 && y < m){
                    int newEffort =  Math.max( Math.abs(heights[row][col] - heights[x][y]), diff); 
                   if(newEffort < dist[x][y]) {
                        dist[x][y] = newEffort; 
                        q.add(new int[]{x, y, newEffort}); 
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
       
        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        int ans = minimumEffortPath(heights);
        
        System.out.print(ans);
        System.out.println();
    }
}