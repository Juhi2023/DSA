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
    public static int getFloor(Node root, int key){
        if(root==null)
            return -1;
            
        if (root.data == key) {
            return key;
        }
        
        if(root.data>key){
            return getFloor(root.left, key);
        }

        int res= getFloor(root.right, key);
        return res!=-1 && res<=key ? res : root.data;
    }

    //Iterative
    //Time Complexity: O(log2 N)
    //Space Complexity: O(1)
    public static int getFloorIterative(Node root, int key){
        int floor = -1;
        Node curr=root;
        while(curr!=null){
            if(curr.data==key){
                return key;
            }
            if(curr.data<key){
                floor=curr.data;
                curr = curr.right;
            }else{
                curr=curr.left;
            }
        }
        return floor;
    }

    public static void main(String args[]){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node (1);
        root.left.right = new Node (3);

        int res = getFloorIterative(root, 5);
        System.out.print(res);

    }
}