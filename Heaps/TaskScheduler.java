import java.util.*;

class TaskScheduler {

    //Heap:
    //At most 2N operations (each task can be popped and re-added).
    // Each heap op = O(log k) → O(log 26) = O(1)
    //Time Complexity: O(2 N)
    //space Complexity: O(k) + O(26) → k elements stored i n temp
    
    public static int getMinTimeByheap(char[] tasks, int k) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }
        int time=0;
        
        while(pq.size()>0){
            List<Integer> temp = new ArrayList<>();
            for(int i=1; i<=k+1; i++){
                if(!pq.isEmpty()){
                    temp.add(pq.poll()-1);
                }
            }
            for(int x : temp) {
                if(x > 0)
                    pq.offer(x);
            }

            if(pq.isEmpty())
                time += temp.size();
            else
                time += (k+1); 
        }
        return time;
    }
    // A A B B B B C D E      K = 3;  
    // B A C D   B A E -   B - - -  B 
    // A - 2 - 1 - 0
    // B - 4 - 3 - 2 - 1
    // C - 1 - 0 - 0
    // D - 1 - 0 - 0
    // E - 1 - 1 - 0


    //Greedy:
    //Time Complexity: O(26 log 26) +O(N)
    //space Complexity: O(26) ~ O(1)
    
    public static int getMinTimeByGreedy(char[] tasks, int k) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq =  freq[25]-1;
        int idleSlots = maxFreq*k;
        for(int i=24; i>=0; i--){
            idleSlots -=  Math.min(freq[i], maxFreq);
        }
        
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    public static void main(String args[]){
        System.out.print(getMinTimeByGreedy(new char []{'A','A','A','B','B','B'}, 2));
    }
}