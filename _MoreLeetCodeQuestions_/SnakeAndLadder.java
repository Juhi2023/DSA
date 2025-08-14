//https://leetcode.com/problems/snakes-and-ladders/description

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int[] cells = new int[n * n + 1]; // 1-based index
        int idx = 1;
        boolean leftToRight = true;

        // Flatten the board into cells[1..n*n]
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    cells[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    cells[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        visited[1]=true;
        q.add(new int[]{1,0});
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int square = curr[0];
            int moves = curr[1];
            if(n*n == square){
                return moves;
            }

            for(int i=square+1; i<= Math.min(square+6, n*n); i++){
                int next = i;
                if(cells[i]!=-1){
                    next = cells[i];
                }
                if (!visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next, moves+1});
                }
                
            }
        }

        return -1;
    }
}