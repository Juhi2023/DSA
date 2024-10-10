
import java.util.* ;

// 1. Brute Force
// 2. Binary Search (in Case of Sorted rows)
// 3.Staircase search (in case of sorted row and columns)

class SearchInSorted2DArray{
    public static void printDiagonalSum(int matrix [][], int key){
        int row=0;
        int col = matrix[0].length-1;
        boolean found=false;

        while(row<matrix.length && col>=0){
            if(matrix[row][col]==key){
                found=true;
                break;
            }else if(matrix[row][col]>key){
                col--;
            }else{
                row++;
            }
                
        }
        
        System.out.print(found);
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        printDiagonalSum(arr, 11);
    }
}