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
        int y;
        public Pair(Node n, int x, int y){
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }

    // Time Complexity: O(N * log2N * log2N * log2N) where N represents the number of nodes in the Binary Tree.
    // Postorder Traversal performed using BFS as a time complexity of O(N) as we are visiting each and every node once.
    // Multiset Operations to insert overlapping nodes at a specific vertical and horizontal level also takes O(log2N) complexity.
    // Map operations involve insertion and retrieval of nodes with their vertical and level as their keys. Since there are two nested maps, the total time complexity becomes O(log2N)*O(log2N).
    
    // Space Complexity: O(N + N/2) where N represents the number of nodes in the Binary Tree.
    // The map for storing nodes based on their vertical and level information occupies an additional space complexity of O(N) as it stores all N nodes of the Binary Tree.
    // The queue for breadth first traversal occupies a space proportional to the maximum level of the tree which can be O(N/2) in the worst case of a balanced tree.

    public static List<List<Integer>> verticalOrderTraversal(Node root) {
        if(root==null)
            return new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        q.offer(new Pair(root, 0, 0));
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0; i<s; i++){
                Pair front = q.poll();
                Node currNode = front.n;
                int x = front.x;
                int y = front.y;
                
                if(!map.containsKey(x)){
                    map.put(x, new TreeMap<>());
                }

                if(!map.get(x).containsKey(y)){
                    map.get(x).put(y, new ArrayList<>());
                }
                map.get(x).get(y).add(currNode.data);
                if(currNode.left != null){
                   q.offer(new Pair(currNode.left, x - 1, y + 1));
                }

                if(currNode.right != null){
                    q.offer(new Pair(currNode.right, x + 1, y + 1));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        for(Map<Integer, List<Integer>> entry : map.values()){
            List<Integer> currList = new ArrayList<>();

            for(List<Integer> subEntry : entry.values()){
                Collections.sort(subEntry);
                currList.addAll(subEntry);
            }
            ans.add(new ArrayList<>(currList));
        }

        //Other way of traversal
        // for(Map.Entry<Integer, Map<Integer, List<Integer>>> entry : map.entrySet()){
        //     List<Integer> currList = new ArrayList<>();

        //     for(Map.Entry<Integer, List<Integer>> subEntry : entry.getValue().entrySet()){
        //         Collections.sort(subEntry.getValue());
        //         currList.addAll(subEntry.getValue());
        //     }
        //     ans.add(new ArrayList<>(currList));
        // }
    
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

        System.out.println(verticalOrderTraversal(root));
    }
}