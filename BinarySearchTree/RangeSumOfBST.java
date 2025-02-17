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
    //Time Complexity: O(N)
    //Space Complexity: O(H)
    public static int rangeSumBST(Node root, int low, int high) {
        if(root==null)
            return 0;
        int sum=0;
        if(root.data>=low && root.data<=high){
            sum+=root.data;
            sum+=rangeSumBST( root.left, low, high);
            sum+=rangeSumBST( root.right, low, high);
        }else if(root.data<low)
            sum+=rangeSumBST( root.right, low, high);
        else
            sum+=rangeSumBST( root.left, low, high);
            
        return sum;
    }

    public static void main(String args[]){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node (1);
        root.left.right = new Node (3);
        System.out.print(rangeSumBST(root, 1, 5));

    }
}