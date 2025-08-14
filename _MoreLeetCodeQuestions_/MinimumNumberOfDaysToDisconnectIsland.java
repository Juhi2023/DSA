//https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/description/

//DFS
//T.C: O(N*M * (N+M))

class Solution {
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(noOfIslands(grid, n, m)!=1)
            return 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(noOfIslands(grid, n, m)!=1) 
                        return 1;
                    grid[i][j]=1;
                }
            }
        }
        return 2;
    }

    public int noOfIslands(int[][] grid, int n, int m){
        int cnt=0;
        int visited[][] = new int [n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    dfs(grid, i, j, n, m, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int grid[][], int i, int j, int n, int m, int visited[][]){
        int dir[][]= {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        visited[i][j]=1;
        for(int k=0; k<4; k++){
            int x = i + dir[k][0];
            int y = j+dir[k][1];

            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1 && visited[x][y]==0){
                dfs(grid, x, y, n ,m, visited);
            }
        }
    }
}


//Articulation point
//T.C: O(N*M)
class Solution {
    int time;
    int[][] vis;
    int[][] low;
    int[] d=new int[]{0,1,0,-1,0};
    boolean arti;
    public int minDays(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        arti=false;
        vis=new int[n][m];
        low=new int[n][m];
        time=1;
        boolean hasArt=false;
        boolean found=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(found)   /// meas there are already more than 1 island
                        return 0;
                    found=true;
                    art(i,j,grid,-100,-100);
                }
            }
        }

        if(time==1)   //means there is no island
            return 0;

        if(time==2)  //means there was only one land cell in the entire grid (an island with a single cell) So, To disconnect the island (i.e., make it empty water), we only need to remove that one cell.
            return 1;

        if(arti)    //There is articulation point
            return 1;
        else
            return 2;
    }

    public void art(int row,int col,int[][] grid , int parRow,int parCol){
        grid[row][col]=0;
        vis[row][col]=time;
        low[row][col]=time;
        time++;
        int child=0;
        for(int i=0;i<4;i++){
            int x=d[i]+row;
            int y=d[i+1]+col;

            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || (x==parRow && y==parCol) || (vis[x][y]==0 && grid[x][y]==0))
                continue;
            if(vis[x][y]==0){
                child++;
                art(x,y,grid,row,col);
                low[row][col]=Math.min(low[row][col],low[x][y]);
                if(low[x][y]>=vis[row][col] && (parRow!=-100 && parCol!=-100))
                    arti=true;
            }else{
                low[row][col]=Math.min(low[row][col],vis[x][y]);
            }
        }

        if(parRow==-100 && parCol==-100 && child>1)
            arti=true;
    }
}