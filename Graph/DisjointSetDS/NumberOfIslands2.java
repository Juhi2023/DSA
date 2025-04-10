import java.util.*;


class NumberOfIslands2 {
    //DSU
    //Time Complexity: O(N * 4alpha)
    //Space Complexity: O(N)+ O(N*M) 
    public static List<Integer> numOfIslands(int n, int m, int[][] operators) {
        int opsize = operators.length;
        DSU dsu = new DSU(n*m);
        int[][] visited = new int[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        int dir[][] = {{0,1}, {0, -1}, {1, 0}, {-1,0}};
        for(int i=0; i<opsize; i++){
            int row = operators[i][0];
            int col = operators[i][1];
            if (visited[row][col] == 1) {
                ans.add(cnt);
                continue;
            }
            visited[row][col]=1;
            cnt++;
            for(int k=0; k<4; k++){
                int x=row+dir[k][0];
                int y=col + dir[k][1];
                if(x>=0 && x<n && y>=0 && y<m && visited[x][y]==1){
                    int node = row * m + col;
                    int adjNode = x * m + y;
                    if(dsu.find(node)!=dsu.find(adjNode)){ // if two island already merged dont reduce count eg 1 --- 1
                                                                                                            //  1  1  1
                        cnt--;
                        dsu.union(node, adjNode);
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;

    }

    

    public static void main (String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        List<Integer> ans = numOfIslands(n, m, operators);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }
}

class DSU{
    int parent[];
    int size[];
    public DSU(int n){
        parent= new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i]=1;
        }
    }

    public int find(int node){
        if(node==parent[node])
        return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int a, int b){
        int pa = find(a);
        int pb= find(b);
        if(pa==pb)
            return;
        else if(pa>pb){
            parent[pb]=pa;
            size[pa]+=size[pb];
        }else{
            parent[pa]=pb;
            size[pb]+=size[pa];
        }
    }
}