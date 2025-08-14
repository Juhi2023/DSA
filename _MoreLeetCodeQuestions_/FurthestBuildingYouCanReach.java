//https://leetcode.com/problems/furthest-building-you-can-reach/description/
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) ->a-b);
        
        int i = 0, diff = 0;
        for (i = 0; i < heights.length - 1; i++) {
            diff = heights[i + 1] - heights[i];
            
            if (diff <= 0) {
                continue;
            }
            if(ladders>0){
                ladders--;
                p.add(diff);
            }else if(p.size()>0 && p.peek()<diff){
                p.add(diff);
                bricks-=p.poll();
            }else{
                bricks-=diff;
            }
            if(bricks<0)
                return i;
        }
        return i;
    }
}