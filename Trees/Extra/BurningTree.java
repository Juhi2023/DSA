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

    //Using BFS
    //Time Complexity: O(2N * log N ) The time complexity arises from traversing the tree to create the parent hashmap, which involves visiting every node once hence O(N), exploring all nodes at a distance of ‘K’ which will be O(N) in the worst case, and the logarithmic lookup time for the hashmap is O( log N) in the worst scenario as well hence O(N + N + log N) which simplified to O(N).
    //Space Complexity: O(3N) 
    public static void makeGraph(Node root, Node prev, HashMap<Integer, List<Integer>> graph){
        if(root==null)
            return;
        if(prev!=null){
            if(!graph.containsKey(root.val))
                graph.put(root.val, new ArrayList<>());
            if(!graph.containsKey(prev.val))
                graph.put(prev.val, new ArrayList<>());
            graph.get(root.val).add(prev.val);
            graph.get(prev.val).add(root.val);
        }
        makeGraph(root.left, root, graph);
        makeGraph(root.right, root, graph);
    }

    public static int amountOfTime(Node root, int start) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        makeGraph(root, null, graph);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int ans=-1;

        while(!q.isEmpty()) {
            int size= q.size();
            for(int i=0; i<size; i++){
                int curr = q.poll();
                for(int point: graph.getOrDefault(curr, new ArrayList<>())){
                    if(!visited.contains(point)){
                        visited.add(point);
                        q.add(point);
                    }
                }
            }
            ans++;
        }
        return ans;
    }
    
    //Using DFS
    //Time Complexity: O(N) 
    //Space Complexity: O(1) 
    public int traverse(Node root, int start, int ans[]){
        int depth = 0;
        if(root==null)
            return depth;
        
        int leftDepth = traverse(root.left, start, ans);
        int rightDepth = traverse(root.right, start, ans);

        if(root.val==start){
            ans[0] = Math.max(leftDepth, rightDepth);
            depth=-1;
        }else if(leftDepth>=0 && rightDepth>=0){
            depth = Math.max(leftDepth, rightDepth)+1;
        }else{
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            ans[0] = Math.max(ans[0], distance);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }
        return depth;
    }

    public int amountOfTimeByDFS(Node root, int start) {
        int ans [] = new int[1];
        traverse(root, start, ans);
        return ans[0];
    }

    public static void main(String args[]){
        Node root = new Node(1);
        Node target = new Node(2);
        root.left = target;
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.left.right.left = new Node (8);
        root.left.right.right = new Node (9);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(amountOfTimeByDFS(root, 3));
    }
}