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
    public static int helper(Node root, int sum[]){
        if(root==null)
            return 0;

        int leftSum = Math.max(0, helper(root.left, sum));
        int rightSum = Math.max(0, helper(root.right, sum));
        sum[0] = Math.max(sum[0], root.data + leftSum + rightSum);
        
        return root.data + Math.max(leftSum, rightSum);
    }

    public static int maxPathSum(Node root) {
        int sum[] = {Integer.MIN_VALUE};
        helper(root, sum);
        return sum[0];
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(maxPathSum(root));
    }
}