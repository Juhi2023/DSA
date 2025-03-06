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
    //Space Complexity: O(N)j
    public static void inOrderTraversl(Node root){
        if(root==null){
            System.out.print(" null ");
            return ;
        }
        inOrderTraversl(root.left);
        System.out.print(root.data + " ");
        inOrderTraversl(root.right);
    }

    //Iterative using stack
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static void inOrderTraverslIterative(Node root){
        if(root==null){
            System.out.print(" null ");
            return;
        }
        Stack<Node> st = new Stack<>();
        Node temp=root;
        while(temp!=null || !st.isEmpty()){
            while(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            temp = st.pop();
            System.out.print(temp.data+" ");
            temp=temp.right;
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

        inOrderTraverslIterative(root);
    }
}