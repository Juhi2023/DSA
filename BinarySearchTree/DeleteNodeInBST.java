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

    //delete
    public static Node helper(Node root){
        if(root.left==null)   //handle node with no or single child
            return root.right;
        else if(root.right==null)
            return root.left;
        
        Node rightChild = root.right;
        Node lastRightChildOfNodeToBeDelete = findPreccedor(root.left);
        lastRightChildOfNodeToBeDelete.right=rightChild;
        return root.left;
    }
    public static Node findPreccedor(Node root){
        Node curr = root;
        while(curr.right!=null)
            curr=curr.right;
        return curr;
    }

    public static Node deleteNode(Node root, int key) {
        if(root==null)
            return root;
        if(root.data==key){
            return helper(root);
        }
        Node curr =root;
        while(root!=null){
            if(root.data>key){
                if(root.left!=null && root.left.data==key){
                    root.left = helper(root.left);
                    break;
                }
                else
                    root=root.left;
            }else{
                if(root.right!=null && root.right.data==key){
                    root.right = helper(root.right);
                    break;
                }
                else
                    root=root.right;
            }
        }
        return curr;
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
        deleteNode(res, 4);
        System.out.println();
        inOrderTraversl(res);
    }
}