class CountNQueens{
    public static boolean isSafe(char[][] board, int row, int col){
        // Check this row on left side
        for(int i=0; i<col; i++ ){
            if(board[row][i]=='Q')
                return false;
        }

        // Check upper diagonal on left side
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j-- ){
            if(board[i][j]=='Q')
                return false;
        }

        // Check bottom diagonal on left side
        for(int i=row+1, j=col-1; i<board.length && j>=0; i++, j-- ){
            if(board[i][j]=='Q')
                return false;
        }

        return true;
    }

    //Time Complexity:  O(n!)
    //Space COmplexity: O(n)
    public static int nQueen(char[][]board, int col){

        if(col== board.length){
            return 1;
        }

        int count=0;
        for(int i=0; i<board.length; i++){
            if(isSafe(board, i, col)){
                board[i][col] = 'Q';
                count+=nQueen(board, col+1);
                board[i][col] = '.';
            }
        }

        return count;

    }

    public static void main(String args[]){
        int n=5;
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }

        System.out.println(nQueen(board, 0));
    }
}