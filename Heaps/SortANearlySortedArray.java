import java.util.PriorityQueue;

class SortANearlySortedArray {
    //Brute Force : sorting
    //Time Complexity: O(n log n)
    //Space Complexity: O(1)

    //Heap
    //Time Complexity: O(n log K)
    //Space Complexity: O(K)
    public static int[] sortArray(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int n = nums.length;

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        int j=0;
        for (int i = k; i < n; i++) {
            pq.add(nums[i]);
            nums[j++] = pq.poll();
        }

        while (!pq.isEmpty()) {
            nums[j++] = pq.poll();
        }
        return nums;
    }

    public static void main(String args[]){
        for(int x:sortArray(new int []{6, 5, 3, 2, 8, 10, 9}, 3))
            System.out.print(x + " ");
    }
}