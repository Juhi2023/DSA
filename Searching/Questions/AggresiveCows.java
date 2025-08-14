import java.util.*;

class AggresiveCows{

    public static boolean canPlaceCows(int stalls[], int cows, int dis){
        int n=stalls.length;
        int cnt=1;
        int last=stalls[0];
        for(int i=0; i<n; i++){
            if(stalls[i]-last>=dis){
                cnt++;
                last = stalls[i];
            }
        }
        return cnt>= cows;
    }

    //Using Brute
    //Time Complexity: O(n*(MAX(stalls[]) - MIN(stalls[])))
    //Space Complexity: O(1)
    public static int maxDistance(int[] stalls, int cowa) {
        int n = stalls.length;
        Arrays.sort(stalls);

        int limit = stalls[n - 1] - stalls[0];
        for (int i = 1; i <= limit; i++) {
            if (canPlaceCows(stalls, i, cowa) == false) {
                return (i - 1);
            }
        }
        return limit;
    }

    //Using Binary Search
    //Time Complexity: O(n* log(MAX(stalls[]) - MIN(stalls[])))
    //Space Complexity: O(1)
    public static int maxDistanceByBS(int stalls[], int cows){
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 0;
        int high = stalls[n-1]-stalls[0];

        while(low<=high){
            int mid = (low+high)/2;
            if(canPlaceCows(stalls, cows, mid)){
                low= mid+1;
            }else{
                high=mid-1;
            }
        }

        return high;
    }

    public static void main(String args[]){
        System.out.println(maxDistance(new int[]{0, 3, 4, 7, 10, 9}, 4));
    }
}