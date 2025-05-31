import java.util.*;

class LongestIncreasingSequenceByBinarySearch {
    //Binary Search
    //Time Complexity: O(N*log N)
    //Space Complexity: O((N)
    
    static int longestIncreasingSubsequence(int arr[], int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        for(int i=1; i<n; i++){
            if(temp.get(temp.size()-1)<arr[i]){
                temp.add(arr[i]);
            }else{
                int index = Collections.binarySearch(temp, arr[i]);
                if(index<0){
                    index = -index-1;
                    temp.set(index, arr[i]);
                }
            }
        }
        return temp.size();
    }
    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;
        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));
    }
}