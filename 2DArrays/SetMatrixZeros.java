
import java.util.* ;
class SetMatrixZeros{

    //Approach 1: Set -1 to the row and the column in  for the element having value zero. 
        //Time Complexity: (O(n*m) * O(n+m)) + O(n*m)
        //Space Complexity: O(1)

    //Approach 2: Create an array row of n Size and col of m size which and will be true if contains zero in row or col
        //Time Complexity: (2 * O(n*m)
        //Space Complexity: O(n+m)

    //Approach 3: store data in row 0 and col 0 instead of new array and create a seperate int var which will contain row 0
        //Time Complexity: 2* O(n*m)
        //Space Complexity: O(1)

    public static void printZeroMatrix(int matrix [][]){
        int n=matrix.length;
        int m=matrix[0].length;
        int col0=1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;

                    if(j==0)
                        col0=0;
                    else
                        matrix[0][j]=0;
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j]!=0){
                    if(matrix[0][j]==0 || matrix[i][0]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }

        if(matrix[0][0]==0){
            for(int j=0; j<m; j++){
                matrix[0][j]=0;
            }
        }

        if(col0==0){
            for(int j=0; j<n; j++){
                matrix[j][0]=0;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[][] arr = {{1,0,3}};
        printZeroMatrix(arr);
    }
}