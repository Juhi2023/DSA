import java.util.*;

class CreateTree{

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            data=val;
            left=null;
            right=null;
        }
    }

    public static class Pair{
        Node n;
        int x;
        public Pair(Node n, int x){
            this.n = n;
            this.x = x;
        }
    }

    //Time Complexity: O(N * log N)
    //N - to traverse each node
    //log N - for insertion operation in tree map
    public static ArrayList<Integer> getTopView(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int s = q.size();
            
            for(int i=0; i<s; i++){
                Pair p = q.poll();
                int x = p.x;
                Node n = p.n;
                if(!map.containsKey(x)){
                    map.put(x, n.data);
                }
                
                if(n.left!=null){
                    q.offer(new Pair(n.left, x-1));
                }
                if(n.right!=null){
                    q.offer(new Pair(n.right, x+1));
                }
                
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int y: map.values()){
            ans.add(y);
        }
        return ans;
    }

    //using hashmap
    //Time Complexity: O(N )
    //N - to traverse each node
    //log N - for insertion operation in tree map
    public static ArrayList<Integer> getTopViewOptimized(Node root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        int min = 0;
        int max = 0;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int s = q.size();
            
            for(int i=0; i<s; i++){
                Pair p = q.poll();
                int x = p.x;
                Node n = p.n;

                if(x<min)
                    min=x;
                if(x>max)
                    max=x;

                if(!map.containsKey(x)){
                    map.put(x, n.data);
                }
                
                if(n.left!=null){
                    q.offer(new Pair(n.left, x-1));
                }
                if(n.right!=null){
                    q.offer(new Pair(n.right, x+1));
                }
                
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=min; i<=max; i++){
            ans.add(map.get(i));
        }
        return ans;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(getTopViewOptimized(root));
    }
}