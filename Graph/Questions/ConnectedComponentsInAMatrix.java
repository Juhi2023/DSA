import java.util.*;

class ConnectedComponentsInAMatrix{

    public static boolean isSafe(String M[], int row, int col, boolean visited[][], char c, int n, int l){
        return (row>=0 && row<n) && (col>=0 && col<l) && M[row].charAt(col)==c && !visited[row][col];
    }
    
    public static void DFS(String M[], int row, int col, boolean visited[][], char c, int n, int l){
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        visited[row][col]=true;
    
        for (int k = 0; k < 4; ++k){
            if (isSafe(M, row + directions[k][0], col + directions[k][1], visited, c, n, l)){
                DFS(M, row +  directions[k][0], col +  directions[k][1], visited, c, n, l);
            }
        }
    
    }
    
    //Time Complexity: (N*M*4)
    //Space Complexity: (N*M)
    public static int connectedComponents(String M[], int n){
        int l = M[0].length();
        int connectedComp = 0;
        boolean visited[][] = new boolean[n][l];
        for(boolean x[]: visited){
            Arrays.fill(x, false);
        }

    
        for (int i = 0; i < n; i++){
            for (int j = 0; j < l; j++){
                if (!visited[i][j]){
                    char c = M[i].charAt(j);
                    DFS(M, i, j, visited, c, n, l);
                    connectedComp++;
                }
            }
        }
    
        return connectedComp;
    }

    public static void main(String[] args) {
        String M[] = {"aabba", "aabba", "aaaca"};
        int n = M.length;
        System.out.println(connectedComponents(M, n));
    }
}