
import java.util.* ;
class SpiralMatrix{
    public static void printSpiralMatrix(int matrix [][]){

        int rowStart=0;
        int colStart=0;
        int rowEnd=matrix.length-1;
        int colEnd=matrix[0].length-1;

        while(rowStart<=rowEnd && colStart<=colEnd){
            //top
            for(int i=colStart; i<=colEnd; i++){
                System.out.print(matrix[rowStart][i]+ " ");
            }

            //right
            for(int i=rowStart+1; i<=rowEnd; i++){
                System.out.print(matrix[i][colEnd]+ " ");
            }

            //bottom
            for(int i=colEnd-1; i>=colStart; i--){
                if(rowStart == rowEnd)
                    break;
                System.out.print(matrix[rowEnd][i]+ " ");
            }

            //left
            for(int i=rowEnd-1; i>=rowStart+1; i--){
                if(colStart == colEnd)
                    break;
                System.out.print(matrix[i][colStart]+ " ");
            }
            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }

        
    }
    public static void printSpiralMatrix2(int matrix [][]) {
        System.out.println();

        int sRow=0, eRow=matrix.length-1, sCol=0, eCol=matrix[0].length-1;

        while(sRow<=eRow && sCol<=eCol){
            for(int i=sCol; i<=eCol; i++){
                System.out.print(matrix[sRow][i]+ " ");
            }
            sRow++;

            for(int i=sRow; i<=eRow; i++){
                System.out.print(matrix[i][eCol]+ " ");
            }
            eCol--;


            if(sRow<=eRow){
                for(int i=eCol; i>=sCol; i--){
                    System.out.print(matrix[eRow][i]+ " ");

                }
            }
            eRow--;

            if(sCol<=eCol){
                for(int i=eRow; i>=sRow; i--){
                    System.out.print(matrix[i][sCol]+ " ");

                }
            }
            sCol++;
        }
        
    }

    public static void main(String [] arg){
        Scanner in= new Scanner(System.in);
        int[][] arr = {{1,2,3,4},{5,6,7,8}, {9,10,11,12}};
        printSpiralMatrix(arr);
        printSpiralMatrix2(arr);
    }
}