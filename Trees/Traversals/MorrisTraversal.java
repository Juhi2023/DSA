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
    //Space Complexity: O(1)
    //Inorder 
    public static void inorderTraversal(Node root){
        List<Integer> inorder = new ArrayList<>();
        Node curr = root;
        while(curr!=null){
            if(curr.left==null){
                inorder.add(curr.data);
                curr = curr.right;
            }else{
                Node prev = curr.left;
                // If the left child is not NULL, find the predecessor (rightmost node in the left subtree)
                while(prev.right!=null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    //If the predecessor's right childis already linked, remove the link,add current node to inorder list,and move to the right child
                    inorder.add(curr.data);
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        System.out.println(inorder);
    }

    public static void preorderTraversal(Node root){
        List<Integer> preorder = new ArrayList<>();
        Node curr = root;
        while(curr!=null){
            if(curr.left==null){
                preorder.add(curr.data);
                curr = curr.right;
            }else{
                Node prev = curr.left;
                // If the left child is not NULL, find the predecessor (rightmost node in the left subtree)
                while(prev.right!=null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right = curr;
                    preorder.add(curr.data);
                    curr = curr.left;
                }else{
                    //If the predecessor's right childis already linked, remove the link,add current node to inorder list,and move to the right child
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        System.out.println(preorder);
    }

    public static void postorderTraversal(Node root){
        List<Integer> postorder = new ArrayList<>();
        Node curr = root;
        while(curr!=null){
            if(curr.right==null){
                postorder.add(curr.data);
                curr = curr.left;
            }else{
                Node prev = curr.right;
                // If the left child is not NULL, find the predecessor (rightmost node in the left subtree)
                while(prev.left!=null && prev.left != curr){
                    prev = prev.left;
                }
                if(prev.left==null){
                    prev.left = curr;
                    postorder.add(curr.data);
                    curr = curr.right;
                }else{
                    //If the predecessor's right childis already linked, remove the link,add current node to inorder list,and move to the right child
                    prev.left = null;
                    curr = curr.left;
                }
            }
        }
        Collections.reverse(postorder);
        System.out.println(postorder);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        preorderTraversal(root);
        inorderTraversal(root);
        postorderTraversal(root);
    }
}