import java.util.*;

class FindCityWithSmallestNumberOfNeighborsAtThresholdDistance {

    // Time Complexity: O(V3)
    // Space Complexity: O(V2)
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int matrix [][]=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)
                    matrix[i][j]=0;
                else 
                    matrix[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<edges.length ;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];
            matrix[u][v]=d;
            matrix[v][u]=d;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE)
                        continue;
                    matrix[i][j]=Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
                }
            }
        }

        int cityNo = -1;
        int cityCnt=n;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold)
                    cnt++;
            }
            if (cnt <= cityCnt) {
                cityCnt = cnt;
                cityNo = i;
            }
        }
        return cityNo;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] edges =  {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;

        int cityNo = findTheCity(n, edges, distanceThreshold);
        System.out.println("The answer is node: " + cityNo);
    }
}
