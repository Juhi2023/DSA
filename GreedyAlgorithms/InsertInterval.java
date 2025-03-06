import java.util.*;

public class InsertInterval{

    // Time Complexity: O(n)
    // Auxiliary Space: O(1)

    public static List<int[]> insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        if (n == 0) {
            list.add(newInterval);
            return list;
        }

        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        while (i < n) {
            list.add(intervals[i++]);
        }
        return list;

        // return list.toArray(new int[list.size()][2]);
    }


    public static void main(String []arg){
        Scanner in= new Scanner(System.in);
        int[][] intervals = {{1, 3}, {6, 9}}; 
        System.out.println(insert(intervals, new int[]{2, 5}));
    }
}