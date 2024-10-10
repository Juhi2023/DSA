import java.util.*;

public class TheCelebrityProblem{
    
    //Brute Force
    //Time Complexity: O(n^2)
    //Spcae Complexity: O(n)
    public static int getCelebrityIndex(int matrix[][]){
        int n= matrix.length;
        int knowMe [] = new int [n];
        int iKnow [] = new int [n];

        for(int i=0; i< n ;i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==1){
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        for(int i=0; i< n ;i++){
            if(knowMe[i]==n-1 && iKnow[i]==0)
                return i;
        }

        return -1;
    }

    
    //Stack
    //Time Complexity: O(n)
    //Spcae Complexity: O(n)
    public static int getCelebrityIndexByStack(int matrix[][]){
        int n = matrix.length;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        while (s.size() > 1) {
            int A = s.pop();
            int B = s.pop();
            if (matrix[A][B]==1) {
                s.push(B);
            }
            else {
                s.push(A);
            }
        }

        int C = s.pop();

        for (int i = 0; i < n; i++) {
            if ((i != C)
                && (matrix[C][i]==1 || matrix[i][C]==0)) {
                return -1;
            }
        }

        return C;
    }

    //Two Pointer
    //Time Complexity: O(n)
    //Spcae Complexity: O(1)
    public static int getCelebrityIndexByTwoPointer(int matrix[][]){
        int n = matrix.length;
        int top = 0;
        int bottom = n - 1;
        while(top < bottom){
            if(matrix[top][bottom] == 1 && matrix[bottom][top] == 1){
                top++;
                bottom--;
            }else if(matrix[top][bottom] == 1 ){
                top++;
            }else if(matrix[bottom][top] == 1){
                bottom--;
            }else{
                top++;
                bottom--;
            }
        }
        if(top < bottom){
            return -1;
        }
        for(int i = 0; i < n; i++){
            if(i == top){
                continue;
            }
            if(matrix[i][top] != 1 || matrix[top][i] != 0){
                return -1;
            }
        }
        return top;
    }

    public static void main(String[] args){
        int[][] matrix = { { 0, 0, 1, 0 },
                           { 0, 0, 1, 0 },
                           { 0, 0, 0, 0 },
                           { 0, 0, 1, 0 } };
        System.out.println(getCelebrityIndex(matrix));
    }
}