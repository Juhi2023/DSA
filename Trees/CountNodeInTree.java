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
    public static int count(Node root){
        if(root==null)
            return 0;
        
        int lh = count(root.left);
        int rh = count(root.right);

        return 1 + lh + rh;
    }

    //Time Complexity: O(log N * log N)
    //Space Complexity: O(H) ~ O(log N)
    public static int findRightHeight(Node root){
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
    public static int findLeftHeight(Node root){
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
    public static int count2(Node root){
        if(root==null)
            return 0;
        
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);
        if(lh==rh)
            return (1<<h)-1;

        return 1 + count2(root.left) + count2(root.right);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(count(root));
    }
}