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
    //Space Complexity: O(H)
    public static void preOrderTraversl(Node root){
        if(root==null){
            System.out.print(" null ");
            return ;
        }
        System.out.print(root.data + " ");
        preOrderTraversl(root.left);
        preOrderTraversl(root.right);
    }

    //Iterative using stack
    //Time Complexity: O(N)
    //Space Complexity: O(H)
    public static void preOrderTraverslIterative(Node root){
        if(root==null){
            System.out.print(" null ");
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            Node temp = st.pop();
            System.out.print(temp.data+ " ");

            if(temp.right!=null){
                st.push(temp.right);
            }else{
                System.out.print(" null ");
            }

            if(temp.left!=null){
                st.push(temp.left);
            }else{
                System.out.print(" null ");
            }
        }

    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        preOrderTraverslIterative(root);
    }
}