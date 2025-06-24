import java.util.*;
class TheKWeakestRowsInAMatrix {
    //Heap + binary seacrh
    // Time Complexity: O(m log n + m log m + k log m)
    // Space Complexity: O(n)

    public static int[] kWeakest(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> {
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0] - b[0];
        });
        for(int i=0; i<n; i++){
            int cnt = binarySearch(mat[i]);
            pq.add(new int[]{cnt, i});
        }
        
        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i]=pq.poll()[1];
        }
        return ans;
    }

    public static int binarySearch(int arr[]){
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid]==0)
                r=mid-1;
            else
                l=mid+1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},
            {1,1,1,1,0},
            {1,0,0,0,0},
            {1,1,0,0,0},
            {1,1,1,1,1}};
        int k = 3;

        int[] ans = kWeakest(mat, k);
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}