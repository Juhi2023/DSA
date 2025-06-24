import java.util.*;

class HandsOfStraights {
    //Brute Force 
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)

    //HashMap + TreeMap
    //Time Complexity: O(n log n + n*k)
    //Space Complexity: O(n)
    public static boolean canDivide(int[] nums, int k) {
        if(nums.length%k !=0){
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(int x: map.keySet()){
            int cnt= map.get(x);
            if(cnt>0){
                for(int j=0; j<k; j++){
                    int nextCard = x+j;

                    if(map.getOrDefault(nextCard, 0)< cnt){
                        return false;
                    }
                    map.put(nextCard, map.get(nextCard)-cnt);
                }
            }
        }
        return true;
    }

    //HashMap + TreeMap
    //Time Complexity: O(n + n*log n + n*k)
    //Space Complexity: O(n)
    public static boolean canDivideByheap(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.keySet());

        while (!minHeap.isEmpty()) {
            int x = minHeap.peek();
            int cnt= map.get(x);
            if(cnt>0){
                for(int j=0; j<k; j++){
                    int nextCard = x+j;

                    if(map.getOrDefault(nextCard, 0)< cnt){
                        return false;
                    }
                    map.put(nextCard, map.get(nextCard)-cnt);
                }
            }
            minHeap.poll();
        }

        return true;
    }


    public static void main(String args[]){
        System.out.print(canDivideByheap(new int []{1,2,3,6,2,3,4,7,8}, 3));
    }
}