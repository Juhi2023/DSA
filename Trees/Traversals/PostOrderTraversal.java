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
    public static void postOrderTraversl(Node root){
        if(root==null){
            System.out.print(" null ");
            return ;
        }
        System.out.print(root.data + " ");
        postOrderTraversl(root.left);
        postOrderTraversl(root.right);
    }

    //Iterative using stack
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static void postOrderTraverslIterativeByTwoStack(Node root){
        if(root==null){
            System.out.print(" null ");
            return;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);

        while(!st1.isEmpty()){
            Node temp = st1.pop();
            st2.push(temp);
            
            if(temp.left!=null){
                st1.push(temp.left);
            }
            if(temp.right!=null){
                st1.push(temp.right);
            }

        }
        while(!st2.isEmpty()){
            System.out.print((st2.pop()).data+ " ");
        }

    }

    //Iterative using stack
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static void postOrderTraverslIterative(Node root){
        if(root==null){
            System.out.print(" null ");
            return;
        }
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while(curr!=null || !st.isEmpty()){
            while(curr !=null){
                st.push(curr);
                curr=curr.left;
            }

            Node temp = st.peek().right;
            if(temp==null){
                temp = st.pop();
                System.out.print(temp.data+ " ");

                while (!st.isEmpty() && temp == st.peek().right) {
                    temp = st.pop();
                    System.out.print(temp.data+ " ");
                }
            }else{
                curr=temp;
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

        postOrderTraverslIterative(root);
    }
}