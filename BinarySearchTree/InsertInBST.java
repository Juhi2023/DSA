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

    //iterative
    public static Node insert(Node root, int val){
        if(root==null)
            return new Node(val);
        Node curr =root;
        Node prev =null;
        while(curr!=null){
            prev=curr;
            if(curr.data<val){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }
        if(prev.data>val)
            prev.left=new Node(val);
        else
            prev.right=new Node(val);
        return root;
    }

    //recursive
    public static Node insertIntoBSTRecursive(Node root, int val) {
        if(root==null)
            return new Node(val);
        if(root.data<val)
            root.right = insertIntoBSTRecursive(root.right, val);
        else
            root.left = insertIntoBSTRecursive(root.left, val);
        return root;
    }

    public static Node buildTree(int val[]){
        Node root=null;
        for(int i=0; i<val.length; i++){
            root = insert(root, val[i]);
        }
        return root;
    }

    public static void inOrderTraversl(Node root){
        if(root==null){
            return ;
        }
        inOrderTraversl(root.left);
        System.out.print(root.data + " ");
        inOrderTraversl(root.right);
    }

    public static void main(String args[]){

        Node res = buildTree(new int[]{5, 1, 3, 4, 2, 7});
        inOrderTraversl(res);

    }
}