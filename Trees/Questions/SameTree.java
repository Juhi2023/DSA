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
    public static boolean isSameTree(Node p, Node q) {
        if(p==null && q==null)
            return true;
        
        if(p!=null && q!=null && p.data==q.data){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String args[]){
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node (4);
        root1.left.right = new Node (5);
        root1.right.left = new Node (6);
        root1.right.right = new Node (7);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node (4);
        root2.left.right = new Node (5);
        root2.right.left = new Node (6);
        root2.right.right = new Node (7);

        System.out.println(isSameTree(root1, root2));
    }
}