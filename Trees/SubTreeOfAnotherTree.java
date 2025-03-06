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

    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
    static boolean areIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;

        return (root.data == subRoot.data &&  areIdentical(root.left, subRoot.left) && areIdentical(root.right, subRoot.right));
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if(subRoot==null)
            return true;
        if(root==null)
            return false;
        
        if(areIdentical(root, subRoot))
            return true;
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        Node subRoot= new Node(2);
        subRoot.left = new Node(4);
        subRoot.right= new Node (5);

        System.out.println(isSubTree(root, subRoot));
    }
}