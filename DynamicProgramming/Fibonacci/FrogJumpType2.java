import java.util.*;

class FrogJumpType2{
    //Recursion
    // Time Complexity: O(3^N)
    // Space Complexity: O(N)
    public static boolean helper( HashSet<Integer> set, int stone, int jump, int lastStone) {
        if(stone==lastStone){
            return true;
        }

        for(int i=jump-1; i<=jump+1; i++){
            if(i > 0 && set.contains(stone+i)){
                if(helper(set, stone+i, i, lastStone))
                    return true;
            }
        }
        return false;
    }

    public static boolean canCross(int[] stones) {
        HashSet<Integer> set = new HashSet<>();
        for(int x: stones){
            set.add(x);
        }
        return helper(set, 0, 0, stones[stones.length-1]);
    }

    //Memoization
    // Time Complexity: O(N*N)
    // Space Complexity: O(N*N)
    public static Boolean helper( HashMap<Integer, Integer> map, int stone, int jump, int lastStone, Boolean[][] dp) {
        int index=map.get(stone);
        if(stone==lastStone){
            return true;
        }
        if(dp[index][jump] != null)
            return dp[index][jump];
            
        for(int i=jump-1; i<=jump+1; i++){
            if(i > 0 && map.containsKey(stone+i)){
                if(helper(map, stone+i, i, lastStone, dp)){
                    dp[index][jump]=true;
                    return true;
                }
            }
        }
        return dp[index][jump]=false;
    }

    public static boolean canCrossByMemo(int[] stones) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n= stones.length;
        Boolean[][] dp = new Boolean[n+1][n + 1];
        int i=0;
        for(int x: stones){
            map.put(x, i++);
        }
        return helper(map, 0, 0, stones[n-1], dp);
    }

    //Tabulation
    // Time Complexity: O(N*N)
    // Space Complexity: O(N*N)
    public static boolean canCrossByTab(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int n= stones.length;
        for(int x:stones){
            map.put(x,new HashSet<>());
        }
        
        map.get(stones[0]).add(0);

        for(int i=0; i<n; i++){
            int s=stones[i];
            for(int jump: map.get(s)){
                if (jump>0 && map.containsKey(s+jump)) 
                    map.get(s+jump).add(jump);
                if (jump-1>0 && map.containsKey(s+jump-1)) 
                    map.get(s+jump-1).add(jump-1);
                if (map.containsKey(s+jump+1)) 
                    map.get(s+jump+1).add(jump+1);
            }
        }
        return map.get(stones[n-1]).size()>0;
    }

    public static void main(String args[]){
        System.out.println(canCrossByTab(new int[]{0,1,3,5,6,8,12,17}));
    }
}