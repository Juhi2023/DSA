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
    //Time Complexity: O(log2 N)
    //Space Complexity: O(H)
    public static int getCeil(Node root, int key){
        if(root==null)
            return -1;
            
        if (root.data == key) {
            return key;
        }
        
        if(root.data>key){
            int res= findCeil(root.left, key);
            return res>0 ? res : root.data;
        }
        return findCeil(root.right, key);
    }

    //Iterative
    //Time Complexity: O(log2 N)
    //Space Complexity: O(1)
    public static int getCeilIterative(Node root, int key){
        int ceil = -1;
        Node curr=root;
        while(curr!=null){
            if(curr.data==key){
                return key;
            }
            if(curr.data>key){
                ceil=curr.data;
                curr = curr.left;
            }else{
                curr=curr.right;
            }
        }
        return ceil;
    }

    public static void main(String args[]){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node (1);
        root.left.right = new Node (3);

        int res = getCeilIterative(root, 5);
        System.out.print(res);

    }
}