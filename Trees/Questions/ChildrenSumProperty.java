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
    public static int convertToCSP(Node root) {
        if(root==null)
            return 0;
        
        int leftSum = convertToCSP(root.left);
        int rightSum = convertToCSP(root.right);
        int currSum = leftSum + rightSum;
        int diff = currSum - root.data;
        if(diff>0)
            root.data += diff;
        else if(root.left !=null){
            root.left.data -= diff;
            root.left.data = convertToCSP(root.left);
        }else if(root.right !=null){
            root.right.data -= diff;
            root.right.data = convertToCSP(root.right);
        }
        return root.data;
    }

    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int convertToCSPOptimized(Node root) {
        if(root==null)
            return 0;
        
        int sum =0;
        if(root.left!=null)
            sum += root.left.data;
        if(root.right!=null)
            sum += root.right.data;
        
        if(sum>=root.data){
            root.data = sum;
        }else{
            if(root.left!=null){
                root.left.data=root.data;
            }
            if(root.right!=null){
                root.right.data=root.data;
            }
        }
        convertToCSPOptimized(root.left);
        convertToCSPOptimized(root.right);
        int total =0;
        if(root.left!=null)
            total += root.left.data;
        if(root.right!=null)
            total += root.right.data;
        if(root.left!=null || root.right!=null)
            root.data=total;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);
        convertToCSP(root);
        System.out.println(root.data);
    }
}