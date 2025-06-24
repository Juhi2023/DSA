import java.util.*;
class KthLargestElementInStream {
    
    public static void main(String args[]) {
        KthLargest obj = new KthLargest(3, new int[]{4, 5,8,2});
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
    }
}

class KthLargest {
    int k;
    PriorityQueue<Integer> pq ;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k=k;
        for(int x: nums){
            add(x);
        }
    }
    
    public int add(int val) {
        if(pq.size()<k|| pq.peek()<val){
            pq.add(val);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        
        return pq.peek();
    }
}
