//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description
 
import java.util.*;

class MaximumSumCombinations {
    static List<Integer> maxCombinations(int N, int K, Integer A[], Integer B[]) {
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B, Collections.reverseOrder());

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );
        Set<String> used = new HashSet<>();

        maxHeap.offer(new int[]{A[0] + B[0], 0, 0});
        used.add("0,0");

        List<Integer> topK = new ArrayList<>();

        for (int count = 0; count < K; count++) {
            int[] top = maxHeap.poll();
            int sum = top[0];
            int i = top[1], j = top[2];

            topK.add(sum);

            if (i + 1 < N && !used.contains((i + 1) + "," + j)) {
                maxHeap.offer(new int[]{A[i + 1] + B[j], i + 1, j});
                used.add((i + 1) + "," + j);
            }

            if (j + 1 < N && !used.contains(i + "," + (j + 1))) {
                maxHeap.offer(new int[]{A[i] + B[j + 1], i, j + 1});
                used.add(i + "," + (j + 1));
            }
        }

        return topK;
    }

    public static List<Integer> maxCombinationsOtherWay(int N, int K, Integer A[], Integer B[]) {
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B, Collections.reverseOrder());

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        // Add initial k pairs (A[0], B[j])
        for (int j = 0; j < Math.min(K, B.length); j++) {
            maxHeap.offer(new int[]{A[0] + B[j], 0, j});
        }
        List<Integer> result = new ArrayList<>();
        // Extract k smallest pairs
        while (K > 0 && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int i = top[1], j = top[2];
            result.add(A[i]+ B[j]);
            K--;

            // If there's a next element in A, push the new pair
            if (i + 1 < A.length) {
                maxHeap.offer(new int[]{A[i + 1] + B[j], i + 1, j});
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int N = 2, K = 2;
        Integer A[] = {3, 2}, B[] = {1, 4};

        List<Integer> result = maxCombinationsOtherWay(N, K, A, B);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}