class Solution {
    public void bfs(int[][] heights, Queue <int[]> q, boolean visited[][], int n, int m ) {
        int d[][]={{1,0}, {-1,0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()){
            int point[] = q.poll();
            int r=point[0];
            int c = point[1];
            visited[r][c]=true;
            for(int i=0; i<4; i++){
                int x= r+d[i][0];
                int y=c+d[i][1];
                if(!(x<0 || y<0 || x>n-1 || y>m-1) && heights[r][c]<=heights[x][y] && !visited[x][y]){
                    q.add(new int[]{x, y});
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean visitedP[][] = new boolean[n][m];
        boolean visitedA[][] = new boolean[n][m];
        Queue<int[]> qp = new LinkedList<>();
        Queue<int[]> qa= new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || j==0){
                    qp.add(new int[]{i, j});
                }
                if(i==n-1 ||j==m-1){
                    qa.add(new int[]{i, j});
                }
            }
        }

        bfs(heights, qp, visitedP, n, m);
        bfs(heights, qa, visitedA, n, m);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                List<Integer> temp = new ArrayList<>();
                if(visitedP[i][j] && visitedA[i][j]){
                    temp.add(i);
                    temp.add(j);
                ans.add(temp);
                }
            }
        }
        return ans;
    }
}