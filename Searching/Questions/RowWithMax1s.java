import java.util.*;

public class RowWithMax1s{
    //Time Complxity: O(n*M)
    //Space Complxity: O(1)
    public static int rowWithMax1sByBruteForce(int[][] arr){
        int index=-1;
        int max=0;
        for(int i=0; i<arr.length; i++){
            int ones=0;
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==1)
                    ones++;
                if(ones>max){
                    max=ones;
                    index=i;
                }
            }
        }
        return index;
    }

    //Time Complxity: O(n*log m)
    //Space Complxity: O(1)
    public static int rowWithMax1sByBinarySearch(int[][] arr){
        int index=-1;
        int max=0;
        for(int i=0; i<arr.length; i++){
            int start=0;
            int end = arr[0].length-1;
            int inerIndex=-1;

            while(start<=end){
                int mid = (start+end)/2;
                if(arr[i][mid]==1){
                    inerIndex=mid;
                    end=mid-1;
                }else{
                    start=mid+1;
                }

            }
            int ones = arr[0].length-inerIndex+1;
            if(inerIndex>=0 &&  ones>max){
                max=ones;
                index=i;
            }

        }
        return index;
    }

    public static int rowWithMax1sByMatrixSearch(int[][] arr){
        int index=-1;
        int row=0, col=arr[0].length-1;
        int n=arr.length;
        while(row<n && col>=0){
            if(arr[row][col]==0){
                row++;
            }else{
                col--;
                index=row;
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[][] arr = {{0, 1, 1, 1},
               {0, 0, 1, 1},
               {1, 1, 1, 1},
               {0, 0, 0, 0}};
        System.out.println(rowWithMax1sByMatrixSearch(arr));
    }
}