import java.util.*;
class BST {
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    public static List<Integer> arr = new ArrayList<>();
  
    //Using inorder traversal
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        arr.add(root.data);
        inorder(root.right);
    }

    public static boolean findTargetByInorder(Node root, int k) {
        inorder(root);
        int i=0, j = arr.size()-1;
        while(i<j){
            int a= arr.get(i);
            int b=arr.get(j);
            int sum = a+b;
            if(sum==k){
                return true;
            }else if(sum<k){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    

    //using Binary Tree Iterator from both side
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    

    public static void main(String[] args) {
 
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
      
        System.out.println(findTargetByInorder(root, 7)); 
    }
}