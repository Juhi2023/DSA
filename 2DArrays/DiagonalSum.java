
import java.util.* ;

class DiagonalSum{
    public static void printDiagonalSum(int matrix [][]){
        int sum=0;
        for(int i=0; i<matrix.length; i++){
            sum+=matrix[i][i];
            if(matrix.length-i-1!=i)
                sum+= matrix[matrix.length-i-1][i];
        }
        System.out.println(sum);
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[][] arr = {{1,2, 3},{4,5,6}, {7,8,9}};
        printDiagonalSum(arr);
    }
}