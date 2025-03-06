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
    public static void levelOrderTraversl(List<List<Integer>> res, Node root, int h){
        if(root==null){
            return ;
        }
        if(res.size()>=h){
            res.add(new ArrayList<>());
        }
        res.get(h).add(root.data);
        levelOrderTraversl(res, root.left, h+1);
        levelOrderTraversl(res, root.left, h+1);
    }

    //Iterative using stack
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static void levelOrderTraverslIterative(Node root){
        if(root==null){
            System.out.print(" null ");
            return;
        }
        List<List<Integer>> l = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                Node curr = q.poll();
                temp.add(curr.data);
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
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

        levelOrderTraverslIterative(root);
    }
}