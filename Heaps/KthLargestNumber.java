import java.util.PriorityQueue;

class KthLargestNumber {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->b-a);
        int n = nums.length  ;

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i])  ;
        }

        int f = k - 1 ;

        while (f > 0) {
            pq.remove()  ;
            f-- ;
        }
        return pq.peek();
    }

    public static void main(String args[]){
        System.out.println(findKthLargest(new int []{3,6,8,2,1,9,4,1}, 3));
    }
}