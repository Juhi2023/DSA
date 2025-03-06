import java.util.*;
class JumpGame2{

    //Using Recursion
    //TIme Complexity: O(N^N)
    //Space Complexity: O(N)
    public static int minimumJumpsUsingRecursion(int nums[], int idx, int jumps){
        if(idx>=nums.length)
            return jumps;

        int minJumps = Integer.MAX_VALUE;   
        for(int i=1; i<=nums[i]; i++){
            minJumps = Math.min(minJumps, minimumJumpsUsingRecursion(nums, idx+nums[i], jumps+1));
        }
        return minJumps;
    }

    //Using DP -- Tabulation
    //TIme Complexity: O(N^2)
    //Space Complexity: O(N)
    public static int minimumJumpsDP(int nums[]){
        int n= nums.length;
        if(n==0 || nums[0]==0)
            return 0;
        
        int jumps[] = new int[n];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;

        for(int i=0; i< n; i++){
            for(int j=1; j<=nums[i]; j++){
                if(i+j<n)
                    jumps[i+j] = Math.min(jumps[i+j], jumps[i]+1);
            }
        }
        return jumps[n-1];
    }

    //Optimized Greedy Approch : fins range from a point max it can go, then find max range it can go from a range and update the range and soon
    //TIme Complexity: O(N)
    //Space Complexity: O(1)
    public static int jumpOptimized(int[] nums) {
        int n= nums.length;
        if(n==1)
            return 0;

        int jumps=0, l=0, r=0;
        while(r<n-1){
            int farthest = 0;
            for(int i=l; i<=r; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 1, 1, 1, 2};
        System.out.println(minimumJumpsDP(nums));
    }
}