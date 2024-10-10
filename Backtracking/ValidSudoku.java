class ValidSudoku {
    public static boolean isValid(char[][] board, int sr, int er, int sc, int ec){
        boolean [] nums = new boolean[9];
        for(int i=sr; i<=er; i++){
            for(int j=sc; j<=ec; j++){
                
                if(board[i][j]!='.'){
                    int num = board[i][j]-'0'-1;
                    if(nums[num])
                        return false;
                    nums[num]=true;
                }
            }
        }

        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        //check each row
        for(int row=0; row<=8; row++){
            if(!isValid(board, row, row, 0, 8))
                return false;
        }

        //check each col
        for(int col=0; col<=8; col++){
            if(!isValid(board, 0, 8, col, col))
                return false;
        }

        //check each grid
        for(int row=0; row<8; row+=3){
            for(int col=0; col<8; col+=3){
                if(!isValid(board, row, row+2, col, col+2))
                    return false;
            }
        }
        
        return true;
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

        System.out.println(isValidSudoku(board));

    }
}