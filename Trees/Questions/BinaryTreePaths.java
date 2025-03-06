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

    public static void helper(Node root, String s, List<String> res) {
        if(root.left==null && root.right==null){
            res.add(s+root.data);
            return;
        }
        if(root.left!=null)
            helper(root.left, s+root.data+"->", res);
        if(root.right!=null)
            helper(root.right, s+root.data+"->", res);
        
    }
    public static List<String> printPath(Node root) {
        List<String> res = new ArrayList<>();
        if(root==null)
            return res; 
        helper(root, "", res);
        return res;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(printPath(root));
    }
}