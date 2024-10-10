class NQueen{
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
    public static void nQueen(char[][]board, int col){

        if(col== board.length){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("----------------------------");

            return;
        }

        for(int i=0; i<board.length; i++){
            if(isSafe(board, i, col)){
                board[i][col] = 'Q';
                nQueen(board, col+1);
                board[i][col] = '.';
            }
        }
    }

    public static void main(String args[]){
        int n=4;
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }

        nQueen(board, 0);
    }
}