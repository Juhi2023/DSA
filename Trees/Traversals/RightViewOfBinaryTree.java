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

    public static class Pair{
        Node n;
        int x;
        public Pair(Node n, int x){
            this.n = n;
            this.x = x;
        }
    }

    //Iterative/Recursive Level order
    //Time Complexity: O(N)
    //Space Complexity: O(N/2)

    //Recursive pre order
    //Time Complexity: O(N)
    //Space Complexity: O(H)   In case of skwed tree O(N)
    public static void helper(Node root, int level, List<Integer> res){
        if(root==null)
            return;
        if(res.size()==level)
            res.add(root.data);
        helper(root.right, level+1, res);   
        helper(root.left, level+1, res);   
    }
    
    public static List<Integer> getRightView(Node root){
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
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

        System.out.println(getRightView(root));
    }
}