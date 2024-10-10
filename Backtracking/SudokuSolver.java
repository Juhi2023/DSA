import java.util.*;

class SudokuSolver{
    public static boolean isSafe(char[][] board, int row, int col, char digit){

        for(int i=0; i<9; i++ ){
            // Check row 
            if(board[row][i]==digit)
                return false;
            
            // Check column 
            if(board[i][col]==digit)
                return false;
        }
        
        int startRow = row - (row%3);
        int startCol = col - (col%3);
        //check grid
        for(int i=0; i<3; i++ ){
            for(int j=0; j<3; j++ ){
                if(board[startRow+i][startCol+j]==digit)
                    return false;
            }
        }
        return true;
    }

    //Time Complexity:  O(9^(n*n))
    //Space COmplexity: O(n)
    public static boolean SudokuSolver(char[][]board, int row, int col){
        if(row== 9 && col==0){
            return true;
        }

        int nextRow = row;
        int nextCol = col+1;

        if(nextCol==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(board[row][col]!='.'){
            return SudokuSolver(board, nextRow, nextCol);
        }

        for(char digit='1'; digit<='9'; digit++){
            if(isSafe(board, row, col, digit)){
                board[row][col] = digit;
                if(SudokuSolver(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;

    }

    public static void main(String args[]){
        char[][] board = {{'.','8','7','6','5','4','3','2','1'},
        {'2','.','.','.','.','.','.','.','.'},
        {'3','.','.','.','.','.','.','.','.'},
        {'4','.','.','.','.','.','.','.','.'},
        {'5','.','.','.','.','.','.','.','.'},
        {'6','.','.','.','.','.','.','.','.'},
        {'7','.','.','.','.','.','.','.','.'},
        {'8','.','.','.','.','.','.','.','.'},
        {'9','.','.','.','.','.','.','.','.'}};

        System.out.println(SudokuSolver(board, 0, 0));
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}