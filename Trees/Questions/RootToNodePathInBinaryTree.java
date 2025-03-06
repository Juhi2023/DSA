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

    public static boolean helper(List<Integer> res, Node root, int x) {
        if(root==null)
            return false;

        res.add(root.data);

        if(root.data==x){
            return true;
        }

        if(helper(res, root.left, x) || helper(res, root.right, x))
            return true;
        
        res.remove(res.size()-1);
        return false;
    }

    public static List<Integer> printPath(Node root, int x) {
        List<Integer> res = new ArrayList<>();

        if(root==null)
            return res;

        helper(res, root, x);
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

        System.out.println(printPath(root, 6));
    }
}