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
    public static int getHeight(Node root){
        if(root==null)
            return 0;
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(getHeight(root));
    }
}