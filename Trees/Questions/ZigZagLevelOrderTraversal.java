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
    //Space Complexity: O(N)
    public static void zigzagTraversal(List<List<Integer>> res, Node root, int h){
        if(root==null){
            return ;
        }
        if(res.size()<=h){
            res.add(new ArrayList<>());
        }
        if(h%2==1)
            res.get(h).add(0, root.data);
        else
            res.get(h).add(root.data);
        zigzagTraversal(res, root.left, h+1);
        zigzagTraversal(res, root.right, h+1);
    }

    public static void zigzagLevelOrder(Node root) {
        List<List<Integer>> res= new ArrayList<>();
        zigzagTraversal(res, root, 0);
        System.out.println(res);
    }

    //Iterative using stack
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static void zigzagTraversalIterative(Node root){
        if(root==null){
            System.out.print(" null ");
            return;
        }
        List<List<Integer>> l = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                Node curr = q.poll();
                if(leftToRight)
                    temp.add(curr.data);
                else
                    temp.add(0, curr.data);
                    
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
            leftToRight=!leftToRight;
            l.add(temp);
        }
        System.out.print(l);

    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        zigzagTraversalIterative(root);
    }
}