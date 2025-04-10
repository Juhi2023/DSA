import java.util.*;
class CourseSchedule2 {
    public static int[] findOrder(int N, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree[] = new int[N];
        int ans[] = new int[N];
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            for (int x: adj.get(i)) {
                indegree[x]++;
            }
        }
        for (int i = 0; i < N; i++) {
            if(indegree[i]==0)
                q.offer(i);
        }
        int k=0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[k++] = node;
            for (int x : adj.get(node)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        if(k!=N)
            return new int[0];
        return ans;
    }


    public static void main(String args[]){
        int prerequisites[][] = {{1,0},{2,0},{3,1},{3,2}};
        int ans[]=findOrder(4, prerequisites);
        for(int x: ans)
            System.out.print(x+" ");
    }
}