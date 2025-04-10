import java.util.*;
class CourseSchedule {
    public static boolean canFinish(int N, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree[] = new int[N];
        int cnt=0;
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
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            for (int x : adj.get(node)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        if(cnt==N)
            return true;
        return false;
    }

    //wihtout make adjancy list saving memeory
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        for(int[] course : prerequisites){
            indegree[course[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            count++;
            for(int[] course : prerequisites){
                if(course[1] == node){
                    indegree[course[0]]--;
                    if(indegree[course[0]] == 0){
                        queue.add(course[0]);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String args[]){
        int prerequisites[][] = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(canFinish(4, prerequisites));
    }
}