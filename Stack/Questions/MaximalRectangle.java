import java.util.*;
class MaximalRectangle {

    //in 3 pass
    //Time Complexity: O(R *( C + C)) 
    //Space Complexity: O(C)
    public static int getArea(int[]row) {
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        for(int i=0; i<=row.length; i++){
            while(!st.isEmpty() &&  (i==row.length || row[st.peek()]>row[i])){
                int height = row [st.pop()];
                int width = st.isEmpty() ? i:  i - st.peek() -1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        for(int i=0; i<m; i++){
            heights[i] = matrix[0][i]-'0';
        }
        int max = getArea(heights);

        for(int row=1; row<n; row++){
            for(int col=0; col<m; col++){
                if(matrix[row][col]=='1')
                    heights[col]++;
                else 
                    heights[col]=0;
                    
            }
            max = Math.max(max, getArea(heights));
        }
        return max;
    }

    public static void main(String args[]){
        char matrix[][]={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
}