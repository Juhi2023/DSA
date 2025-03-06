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

    
    public static int isSumProperty(Node root) {
        if(root==null || (root.left==null && root.right==null))
            return 1;
        
        int sum=0;
        if(root.left!=null){
            sum+=root.left.data;
        }

        if(root.right!=null){
            sum+=root.right.data;
        }
        
        if(root.data==sum && isSumProperty(root.left)==1 && isSumProperty(root.right)==1){
            return 1;
        }
        return 0;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(isSumProperty(root));
    }
}