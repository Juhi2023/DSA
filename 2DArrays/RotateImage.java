
import java.util.* ;

class RotateImage{
    public static void printRotateImage(int matrix [][]){
        int n=matrix.length;

        //transpose
        for(int i=0; i< n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && j<i){
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }

        //reverse the row
        for(int i=0; i< n; i++){
            for(int j=0; j<n/2; j++){
                    int temp= matrix[i][n-1-j];
                    matrix[i][n-j-1]= matrix[i][j];
                    matrix[i][j] =temp;
            }
        }
        
        for(int i=0; i< n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[][] arr = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}, 
            {1,4,6,8}
        };
        printRotateImage(arr);
    }
}