//https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

import java.util.*;

public class MergeIntervals{

    // Time Complexity: O(n * log n) + O(2n)
    // Auxiliary Space: O(1)

    public static List<List<Integer>> findByTwoPass(int [][] arr) {
        List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(arr, (a, b) -> a[0] - b[0]);

       for(int i=0; i<arr.length; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            for(int j=i+1; j< arr.length; j++){
                if(end> arr[j][0]){
                    end = Math.max(arr[j][1], end);
                    i++;
                }else{
                    break;
                }
            }

            ans.add(Arrays.asList(start, end));
       }

       return ans;
    }

    // Time Complexity: O(n * log n) + O(n)
    // Auxiliary Space: O(1)

    public static List<List<Integer>> findBySinglePass(int [][] arr) {
        List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(arr, (a, b) -> a[0] - b[0]);

       for(int i=0; i<arr.length; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if(ans.isEmpty() || start > ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(start, end));
                continue;
            }else{
                List<Integer> interval = ans.get(ans.size()-1);
                interval.set(1, Math.max(end, interval.get(interval.size()-1)));
            }
       }

       return ans;
    }

    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        System.out.println(findByTwoPass(intervals));
    }
}