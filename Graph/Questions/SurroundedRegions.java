import java.util.*;
class SurroundedRegions{

    //Time Complexity: O(N) + O(M) (FOR TRAVERSING BOUNDRY) + O(NxMx4) 
    //Space Complexity: O(N*M)
    public static void dfs(int row, int col, int n, int m, char[][] board, boolean visited[][]) {
        int directions[][]={{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        visited[row][col]=true;
        for(int i=0; i<4; i++){
            int x = row + directions[i][0];
            int y = col + directions[i][1];
            if(x>=0 && x< n && y>=0 && y<m && visited[x][y]==false && board[x][y]=='O'){
                dfs(x, y, n, m, board, visited);
            }
        }
    }
    

    public static void solve(char[][] board) {
        int n = board.length;
        int m =board[0].length;
        boolean visited[][] = new boolean[n][m];
        for(boolean x[]: visited)
            Arrays.fill(x, false);

        for(int i=0; i<n; i++){
            if(board[i][0]=='O' && visited[i][0]==false){
                dfs(i, 0, n, m, board, visited);
            }
        }
        for(int i=0; i<n; i++){
            if(board[i][m-1]=='O' && visited[i][m-1]==false){
                dfs(i, m-1, n, m, board, visited);
            }
        }
        for(int i=0; i<m; i++){
            if(board[0][i]=='O' && visited[0][i]==false){
                dfs(0, i, n, m, board, visited);
            }
        }
        for(int i=0; i<m; i++){
            if(board[n-1][i]=='O' && visited[n-1][i]==false){
                dfs(n-1, i, n, m, board, visited);
            }
        }
        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(visited[i][j] == false && board[i][j] == 'O') 
                    board[i][j] = 'X'; 
            }
        }
    }

     public static void main(String[] args){
        char mat[][] = {
        {'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'O', 'O', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'X', 'O', 'O'}};

        // n = 5, m = 4
        solve(mat);

        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}