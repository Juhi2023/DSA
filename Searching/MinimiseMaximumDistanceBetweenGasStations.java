import java.util.*;

public class MinimiseMaximumDistanceBetweenGasStations {

    //Brute Force
    //TIme Complexity: O(N*k)
    //Space Complexity: O(N)

    public static double minimiseMaxDistanceByBrute(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        for (int gasStations = 1; gasStations <= k; gasStations++) {

            //Find the maximum section and insert the gas station:
            double maxSection = -1;
            int maxInd = -1;
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double)(howMany[i] + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            howMany[maxInd]++;
        }

        //Find the maximum distance i.e. the answer:
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double)(howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }

    public static class Gap {
        double length;
        int parts;

        Gap(double length) {
            this.length = length;
            this.parts = 1; 
        }

        double getMaxSegment() {
            return length / parts;
        }
    }


    //Using Heap
    //TIme Complexity: O(N*log N + k*log N)
    //Space Complexity: O(N)
    public static double minimiseMaxDistance(int[] stations, int k) {
        PriorityQueue<Gap> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b.getMaxSegment(), a.getMaxSegment())
        );

        // Step 1: Calculate initial gaps
        for (int i = 1; i < stations.length; i++) {
            maxHeap.add(new Gap(stations[i] - stations[i - 1]));
        }

        // Step 2: Add K new stations greedily
        for (int i = 0; i < k; i++) {
            Gap largest = maxHeap.poll();
            largest.parts++; // split further
            maxHeap.add(largest);
        }

        // Step 3: The answer is the largest gap remaining
        return maxHeap.peek().getMaxSegment();
    }

    //Using Binary Search
    //TIme Complexity:  O(n*log(Len)) + O(n),
    //Space Complexity: O(1)
    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length; // size of the array
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

    public static double minimiseMaxDistanceByBS(int[] arr, int k) {
        int n = arr.length; // size of the array
        double low = 0;
        double high = 0;

        //Find the maximum distance:
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }

        //Apply Binary search:
        double diff = 1e-6 ;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationsRequired(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        double ans = minimiseMaxDistanceByBS(arr, k);
        System.out.println("The answer is: " + ans);
    }
}
