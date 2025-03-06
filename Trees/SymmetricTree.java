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

    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static boolean helper(Node root1, Node root2){
        if(root1==null || root2==null){
            return root1==root2;
        }
        return root1.val== root2.val && helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }

    public static boolean isSymmetric(Node root) {
        if(root==null)
            return true;
        return helper(root.left, root.right);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);
        System.out.println(isSymmetric(root));
    }
}