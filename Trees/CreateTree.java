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

    public static void main(String args[]){
        Node root = new Node(1);
        System.out.println(root.data);
    }
}