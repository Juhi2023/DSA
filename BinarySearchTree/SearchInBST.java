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

    //Recursive
    //Time Complexity: O(log2 N)
    //Space Complexity: O(H)
    public static Node searchInBST(Node root, int val){
        if(root==null || root.data==val)
            return root;
        if(root.data>val)
            return searchInBST(root.left, val);
        return searchInBST(root.right, val);
    }

    //Iterative
    //Time Complexity: O(log2 N)
    //Space Complexity: O(1)
    public static Node searchInBSTIterative(Node root, int val){
        while (root != null && root.data != val) {
            root = val < root.data ? root.left : root.right;
        }
        return root;
    }

    public static void main(String args[]){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node (1);
        root.left.right = new Node (3);

        Node res = searchInBSTIterative(root, 3);
        System.out.print(res.data);

    }
}