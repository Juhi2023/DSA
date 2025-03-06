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
        int index;
        public Pair(Node n, int index){
            this.n = n;
            this.index = index;
        }
    }

    public static int maxWidth(Node root) {
        if(root==null)
            return 0;
        int ans=0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int leftIndex = q.peek().index, rightIndex=0;

            for(int i=0; i<size; i++){
                Node curr = q.peek().n;
                int index = q.peek().index;
                q.poll();

                if (i == size - 1) {
                    rightIndex = index;
                }

                if(curr.left!=null){
                    q.offer(new Pair(curr.left, 2*index+1));
                }

                if(curr.right!=null){
                    q.offer(new Pair(curr.right, 2*index+2));
                }
            }
            ans= Math.max(ans, rightIndex-leftIndex+1);
        }
        return ans;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(maxWidth(root));
    }
}