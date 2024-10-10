class WordSearch {
    public static int rowMove[]={1, 0, 0, -1};
    public static int colMove[]={0, -1, 1, 0};

    //Time Complexity: O(4^k * (n*m))
    //Space Complexity: O(k) (stack)
    public static boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        int index = 0;

        // First search the first character
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (findWord(board, word, 0, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    public static boolean isSafe(char[][]board, char c, int row, int col){
        return (row>=0 && row<board.length && col>=0 && col<board[0].length && board[row][col]==c);
    }

    public static boolean findWord(char[][]board, String word, int index, int row, int col){
        if(index==word.length())
            return true;
        
        if(!isSafe(board, word.charAt(index), row, col))
            return false;
            
        for(int i =0 ; i<4; i++){
            int nextRow = row+rowMove[i];
            int nextCol = col+colMove[i];

            board[row][col]='.';
            if(findWord(board, word, index+1, nextRow, nextCol))
                return true;
            board[row][col]=word.charAt(index);
            
        }

        return false;
    }


    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};

        String word = "ABCCED";

        boolean res = exist(board, word);
        System.out.println(res);
    }
}