import java.util.*;

class SlidingWindowMinimum{

    //Brute Force
    //Time Complexity: O(N*k)
    //Space Complexity: O(N-k)

    //Using Deque
    //Time Complexity: O(N)
    //Space Complexity: O(k)

    public static int [] getMinimums(int nums[], int k){
        int n = nums.length;
        int result [] = new int [n-k+1];

        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i])
                dq.removeLast();
            dq.addLast(i);
        }
        result[0] = nums[dq.getFirst()];
        for(int i=k; i<n; i++){
            // remove all element which are out of window
            while(!dq.isEmpty() && dq.getFirst() <= i-k )
                dq.removeFirst();
            
            // remove all elements which are smaller than current element in window
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i])
                dq.removeLast();
                
            dq.addLast(i);
            
            result[i-k+1] = nums[dq.getFirst()];
        }
        return result;
    }

    public static void main(String args[]){
        int ans [] = getMinimums(new int[] {1,3,1,2,0,5}, 3);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
}