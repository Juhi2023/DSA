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
    public static int getKthAnccesstor(Node root, int k, int val, int ans[]){
        if(root==null)
            return -1;
        
        if(root.data==val)
            return 0;
        
        int lefDist = getKthAnccesstor(root.left, k, val, ans);
        int rightDist = getKthAnccesstor(root.right, k, val, ans);

        if(lefDist==-1 && rightDist==-1)
            return -1;
        int max = Math.max(lefDist, rightDist);
        if(max+1==k)
            ans[0]=root.data;

        return 1 + max;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);
        int ans[]={0};
        getKthAnccesstor(root, 1, 7, ans);

        System.out.println(ans[0]);
    }
}