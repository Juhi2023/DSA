import java.util.*;

//Why limit as 6000
// for test case:
// a = 1999
// b = 2000
// x = 2000
// forbidden = [1998]
// if we need to reach x = 2000, there are 2 ways:
// first, from 1 jump forward 1 + a = 2000
// second, from 4000 jump backward 4000 - b = 2000
// however, 1998 is forbidden, this means when jump forward 2 times from 0, it is 3998, then jump back 2000, it's 1998, but it can't jump to 1998, this means it can't jump to 1 like this way.
// so, we have to use another way, from 4000 jump backward
// how to reach 4000, we have to jump forward 3 times to 3 * 1999 = 5997,3997
// in this way, jump forward and backward each time, we can reach 4000, and it is jump forward to 4000, then we jump backward 2000, it's 2000.

public class MinimumJumpsToReachHome {

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> forbid = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        int furthest = 6000;
        for (int num : forbidden) {
            forbid.add(num);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited.add("0,1");
        while(!q.isEmpty()){
            int p[]= q.poll();
            int point = p[0];
            int jumps=p[1];
            int dir = p[2];

            if(point==x){
                return jumps;
            }

            int forward = point + a;
            if(!visited.contains((forward)+",1") && !forbid.contains(forward) && forward <furthest){
                q.add(new int[]{forward, jumps+1, 1});
                visited.add(forward+",1");
            }
            int backward = point - b;
            if (dir == 1 && backward >= 0 && backward < furthest && !forbid.contains(backward) && !visited.contains(backward + ",0")) {
                q.add(new int[]{backward, jumps + 1, 0});
                visited.add(backward + ",0");
            }
        } 
        return -1;
    }

    public static void main(String[] args) {
        int[] forbidden = {14, 4, 18, 1, 15};
        int a = 3, b = 15, x = 9;
        System.out.println(minimumJumps(forbidden, a, b, x)); 
    }
}
