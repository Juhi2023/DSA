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
    
    public static int getHeight(Node root){
        if(root==null)
            return 0;
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return 1 + Math.max(lh, rh);
    }

    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
    public static int getDiameter(Node root){
        if(root==null)
            return 0;
        
        int leftDia = getDiameter(root.left);
        int rightDia = getDiameter(root.right);
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        int selfDia = leftDia + rightDia + 1;
        return Math.max(selfDia, Math.max(rightDia, leftDia));
    }
    

    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int getDiameterOptimized(Node root, int[]diameter){
        if(root==null)
            return 0;
        int lh = getDiameterOptimized(root.left, diameter);
        int rh = getDiameterOptimized(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh+rh);

        return 1+ Math.max(lh, rh);
    }

    public static int diameterOfBinaryTree(Node root) {
        int diameter[] = new int[1];
        getDiameterOptimized(root, diameter);
        return diameter[0];
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(diameterOfBinaryTree(root));
    }
}