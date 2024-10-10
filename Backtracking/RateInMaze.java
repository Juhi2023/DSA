import java.util.*;
class RateInMaze{
    public static String direction = "DLRU"; //lexographically
    public static int rowMove[] = {1, 0, 0, -1};
    public static int colMove[] = {0, -1, 1, 0};

    //Time Complexity: O(3^(n*m))
    //Space Complexity: O(n*m) (stack) + O(n*m) (Auxilariy)
    public static boolean canVisit(int [][] mat, int i, int j, int n, int m, int visited[][]){
        if(i>=0 && i<n && j>=0 && j<m && mat[i][j]==1 && visited[i][j]!=1)
            return true;
        return false;
    }

    public static void getWaysListByUsingSpace(int mat[][], int row, int col, int n, int m, StringBuilder path, int visited[][], List<String> ans){
        if(row==n-1 && col==m-1){
            ans.add(path.toString());
            return;
        }


        for(int i=0; i<4; i++){
            int nextRow = row+ rowMove[i];
            int nextCol = col + colMove[i]; 
            if(canVisit(mat, nextRow, nextCol, n, m, visited)){
                visited[row][col]=1;
                path.append(direction.charAt(i));
                getWaysListByUsingSpace(mat, nextRow, nextCol, n, m, path, visited, ans);
                path.deleteCharAt(path.length()-1);
                visited[row][col]=0;
            }
        }

    }


    //Time Complexity: O(3^(n*m))
    //Space Complexity: O(n*m) (stack)
    public static boolean isSafe(int [][] mat, int i, int j, int n, int m){
        if(i>=0 && i<n && j>=0 && j<m && mat[i][j]==1)
            return true;
        return false;
    }

    //Get no of ways
    public static int getWays(int [][] mat, int i, int j, int n, int m){
        if(i==n-1 && j==m-1)
            return 1;

        int count=0;
        mat[i][j]=0;
        for(int k=0; k<4; k++){
            int nextRow = i + rowMove[k];
            int nextCol = j + colMove[k];
            if(isSafe(mat, nextRow, nextCol, n, m)){
                count+=getWays(mat, nextRow, nextCol, n, m);
            }
        }
        mat[i][j]=1;

        return count;
    }

    //Get list of ways
    public static void getWaysList(int [][] mat, int i, int j, int n, int m, StringBuilder path, List<String> ans){
        if(i==n-1 && j==m-1){
            ans.add(path.toString());
            return;
        }

        mat[i][j]=0;
        for(int k=0; k<4; k++){
            int nextRow = i + rowMove[k];
            int nextCol = j + colMove[k];
            if(isSafe(mat, nextRow, nextCol, n, m)){
                path.append(direction.charAt(k));
                getWaysList(mat, nextRow, nextCol, n, m, path, ans);
                path.deleteCharAt(path.length()-1);
            }
        }
        mat[i][j]=1;

    }
    public static void main(String []args){
        int[][] mat = {{1, 0, 0, 0},
                {1, 1, 0, 1}, 
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        List<String> ans = new ArrayList<>();

        System.out.println(getWays(mat, 0, 0, 4, 4));
        if (mat[0][0] == 1)
            getWaysList(mat, 0, 0, 4, 4, new StringBuilder(), ans);
        System.out.println(ans);
    }
}