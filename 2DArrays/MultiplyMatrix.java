
import java.util.* ;

class MultiplyMatrix{

// Time Complexity: O(n*m*o)
    public static void multiply(int matrix1 [][], int matrix2 [][]){
        int n=matrix1.length;       // matrix1 total row
        int m= matrix1[0].length;   // matrix1 total column
                                    //matrix1 total col = matrix2 total row
        int o= matrix2[0].length;    //matrix2 total col
        int ans [][] = new int[n][o];

        for(int i=0; i< n; i++){
            for(int j=0; j<o; j++){
                for(int k=0; k<m; k++){
                    ans[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        for(int i=0; i< n; i++){
            for(int j=0; j<o; j++){
                System.out.print(ans[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[][] arr1 = {{1,3,5},{2,3,3}, {1,4,6}, {0,0,2}, {0,0,2}, {0,0,2}};
        int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9, 10, 11,12}};
        multiply(arr1, arr2);
    }
}