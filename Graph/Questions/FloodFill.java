import java.util.*;

class FloodFill {

    //Time Complexity: O(n*m*4)
    //Space Complexity: O(n*m) //Recursive stack
    public static void dfs(int[][] image, int target, int i, int j, int color, int n, int m){
        image[i][j]=color;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for(int k=0; k<4; k++){
            int x=i+directions[k][0];
            int y=j+directions[k][1];
            if(x>=0 && x<n &&y>=0 && y<m && image[x][y]==target && image[x][y]!=color){
                dfs(image, target, x, y, color, n, m);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        int n=image.length;
        int m=image[0].length;
        dfs(image, target, sr, sc, color, n, m);
        return image;
    }

    public static void printArray(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1}, 
            {1, 1, 0}, 
            {1, 0, 1}
        };

        int sr = 1, sc = 1, newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);

        printArray(result);
    }
}
