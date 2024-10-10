import java.util.*;
class FindPeakElementII{
    //Brute Force
    //Time Complexity: O(n *m)
    //Space Complexity: O(1)
    

    //Binary Search
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int ans[]={-1,-1};
        int low=0;
        int high =n-1;
        while(low<=high){
            int mid=(low+high)/2;
            int max=Integer.MIN_VALUE;
            int colIndex=-1;

            for(int i=0; i< mat[0].length; i++){
                if(mat[mid][i]> max){
                    max=mat[mid][i];
                    colIndex = i;
                }
            }

            int up = mid-1 >=0 ? mat[mid-1][colIndex] : -1;
            int down = mid+1<n ? mat[mid+1][colIndex] : -1;

            if(up < mat[mid][colIndex] && down <mat[mid][colIndex]){
                ans[0]=mid;
                ans[1]=colIndex;
                return ans;
            }else if(mat[mid][colIndex]<down){
                low= mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    
    public static void main(String args[]){
        int arr[][] = {{10,30,40,50,20},{1,60,2,500,4}};
        int ans[] = findPeakGrid(arr);
        System.out.println("["+ans[0]+", "+ans[1]+"]");
    }
}