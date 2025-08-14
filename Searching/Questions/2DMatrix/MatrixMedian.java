import java.util.*;

class MatrixMedian{
    //Brute Force
    //Time Complexity: O((m*n) log (n*m))
    //Space Complexity: O(m*n)
    

    //Binary Search
    //Time Complexity: O(n log m * log(maxVal – minVal))
    //Space Complexity: O(1)
    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    static int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }
    
    public static int median(int[][] mat) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int n = mat.length;
        int m = mat[0].length;
    
        for(int i=0; i<n; i++){
            low = Math.min(mat[i][0], low);
            high = Math.max(mat[i][m-1], high);
        }
        
        while(low<=high){
            int mid = (low+high)/2;
            
            int smallEqual = countSmallEqual(mat, n, m, mid);
            if(smallEqual <= (n*m)/2){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        
        return low;
    }
    
    public static void main(String args[]){
        int arr[][] = {{1, 3, 5}, 
                {2, 6, 9}, 
                {3, 6, 9}};
        int ans = median(arr);
        System.out.println(ans);
    }
}