import  java.util.*;
class MColoringProblem{

    //Time Complexity: O(n^m)
    //Space Complexity: O(n)
    public static boolean isSafe(List <Integer> [] g,int node, int col, int color[]){
        for(int i=0 ;i< g[node].size(); i++){
            if(color[g[node].get(i)]==col)
                return false;
        }
        return true;
    }
    
    public static boolean solveUsingAdjcencyList(List <Integer> [] g,int node, int n, int color[], int m){
        if(node==n){
            return true;
        }
        
        for(int i=1; i<=m; i++){
            if(isSafe(g, node, i, color)){
                color[node]=i;
                if(solveUsingAdjcencyList(g, node+1, n, color, m)){
                    return true;
                }
                color[node]=0;
            }
        }
        
        return false;
    }

    public static boolean isSafeinAdjcencyMatrix(int [][] g ,int node, int col, int color[]){
        for(int i=0 ;i< g.length; i++){
            if(g[node][i]==1 && color[i]==col)
                return false;
        }
        return true;
    }
    
    public static boolean solveUsingAdjcencyMatrix(int [][] g,int node, int n, int color[], int m){
        if(node==n){
            return true;
        }
        
        for(int i=1; i<=m; i++){
            if(isSafeinAdjcencyMatrix(g, node, i, color)){
                color[node]=i;
                if(solveUsingAdjcencyMatrix(g, node+1, n, color, m)){
                    return true;
                }
                color[node]=0;
            }
        }
        
        return false;
    }

    public static void main( String args[]){
        //using Adjacency list
        int edges[][] = {{0,1},{1,2},{2,3},{3,0},{0,2}} ;
        int n=4;
        int m=3;
        List <Integer> [] g = new ArrayList[n];
        for(int i=0 ;i< n; i++){
            g[i]= new ArrayList<>();
        }
        for(int[] i : edges){
            g[i[0]].add(i[1]);
            g[i[1]].add(i[0]);
        }
        int color[] = new int[n];
        System.out.println(solveUsingAdjcencyList(g, 0, n, color, m));

        Arrays.fill(color, 0);
        int [][] graph = {
            {1,1,1,0},
            {1,0,1,0},
            {1,1,0,1},
            {1,0,1,0}
        };

        System.out.println(solveUsingAdjcencyMatrix(graph, 0, n, color, m));
    }
}