import java.util.PriorityQueue;

class KMostFrequentElements {
    //HashMap and Sorting
    //Time Complexty: O(N + d *log d)   -- d- distinct elements
    //Space Complexty: O(d)

    //HashMap and Heap
    //Time Complexty: O(n + d log k + k log k)  -- d- distinct elements
    //Space Complexty: O(d)
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        for(int x: map.keySet()){
            pq.add(new int[]{x, map.get(x)});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[]= new int[k];
        int i=k-1;
        while(!pq.isEmpty()){
            ans[i--]= pq.poll()[0];
        }  
        return ans; 
    }

    public static void main(String args[]){
        System.out.println(topKFrequent(new int []{3,6,8,8,8,2,1,9,4,1}, 3));
    }
}