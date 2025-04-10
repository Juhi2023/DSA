import java.util.*;
class Representation{

    public static void main(String args[]){
        int v=4, e=4;
        int edges[][]= {{1,2}, {2, 3}, {3, 4}, {1, 3}};


        //ADJANCY MATRIX
        //Space Complexity; O(V^2)
        int adMatrix [][]= new int[v+1][v+1];

        for(int i=0; i<e; i++){
            adMatrix[edges[i][0]][edges[i][1]] = 1;
            adMatrix[edges[i][1]][edges[i][0]] = 1;
        }

        for(int i=0; i<=v; i++){
            for(int j=0; j<=v; j++){
                System.out.print(adMatrix[i][j] + " ");
            }
            System.out.println();
        }

        //ADJANCY LIST
        //Space Complexity; O(2*E)
        ArrayList<ArrayList<Integer>> adList= new ArrayList<>();

        for(int i=0; i<v+1; i++){
            adList.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            adList.get(edges[i][1]).add(edges[i][0]);
            adList.get(edges[i][0]).add(edges[i][1]);
        }

        System.out.print(adList);
        
    }
}