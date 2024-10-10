import java.util.*;
class CheckKnightTourConfiguration{

    public static boolean isSafe(int [][] ans, int x, int y, int n){
        if(x>=0 && x<n && y>=0 && y<n && ans[x][y]==-1 )
            return true;
        return false;
    }
    //Time Complexity: O(8^(n*m))
    //Space Complexity: O(n*m) (stack)
    public static boolean knightTour(int [][] ans, int xMove[], int yMove[], int n, int x, int y, int move){

        if(move==n*n-1){
            return true;
        }
        
        for(int i=0; i<8; i++){
            int nextX = x + xMove[i];
            int nextY = y+ yMove[i];

            if(isSafe(ans, nextX, nextY, n)){
                ans[nextX][nextY] = move;
                if(knightTour(ans, xMove, yMove, n, nextX, nextY, move+1)){
                    return true;
                }else{
                    ans[nextX][nextY]=-1;
                }
            }
        }
        return false;
    }


    //Check Knight Tour Configuration
    public static boolean isSafe(int[][] grid,  int x, int y, int n, int move){
        if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==move)
            return true;
        return false;
    }

    public static boolean knightTourConfiguration(int[][] grid, int xMove[], int yMove[], int n, int x, int y, int move){


        if(move==n*n-1){
            return true;
        }
        
        for(int i=0; i<8; i++){
            int nextX = x + xMove[i];
            int nextY = y+ yMove[i];

            if(isSafe(grid, nextX, nextY, n, move+1)){
                if(knightTour(grid, xMove, yMove, n, nextX, nextY, move+1)){
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String args[]){
        int n=7;
        int [][] ans = new int[n][n];

        for (int[] row: ans)
            Arrays.fill(row, -1);
        ans[0][0] = 0;

        int xMove[] = {2, 2, -2, -2, 1, 1, -1, -1};
        int yMove[] = {-1,1, -1, 1,-2, 2, -2, 2};

        if(knightTour(ans, xMove, yMove, n, 0, 0, 0))
            for(int[] x : ans ){
                for(int i: x){
                    System.out.print(i+" ");
                }
                System.out.println();
            }



    //Check Knight Tour Configuration
        int grid [][] = {{8,3,6},{5,0,1},{2,7,4}};
        if(grid[0][0]!=0) 
            System.out.println("false");
        else
            System.out.println(knightTourConfiguration(grid, xMove, yMove, 3, 0, 0, 0));
    }
}