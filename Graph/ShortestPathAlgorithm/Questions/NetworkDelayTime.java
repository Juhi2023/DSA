import java.util.*;
class NetworkDelayTime {
    public static class Pair{
        int n;
        int wt;
        Pair(int n, int wt){
            this.n = n;
            this.wt = wt;
        }
    }
    
    // Time Complexity: O( E log(V) )
    // Space Complexity: O( |E| + |V|)
    
    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        int dis[] = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);


        dis[k]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.wt-y.wt);
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            for(Pair x: adj.get(node.n)){
                int v= x.n;
                int wt=x.wt;
                if(node.wt + wt < dis[v]){
                    dis[v] = node.wt + wt ;
                    pq.add(new Pair(v, dis[v]));
                }
            }
        }
        int ans=-1;
        for(int i=1; i<=n; i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans, dis[i]);
        }
        return ans;
    }

    public static void main(String args[]){
        int times[][]={{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times, 4, 2));
    }
}