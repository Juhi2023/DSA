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

    //Using DFS
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int maxDepth = 0;
    public static void helper(Node root, int level, int res[]){
        if(root==null)
            return;
        if(level> maxDepth){
            res[0] = root.data;
            maxDepth = level;
        }
        if(root.left != null)
            helper(root.left, level+1, res);
        if(root.right !=null)
            helper(root.right, level+1, res);
        
    }
    public static int findBottomLeftValueByDFS(Node root) {
        int res[] = new int[1];
        helper(root, 1, res);
        return res[0];
    }

    //Using BFS
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int findBottomLeftValueByBFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node current = root;
        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null) {
                queue.add(current.left);
            }
        }
        return current.data;
    }


    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(findBottomLeftValueByBFS(root));
    }
}