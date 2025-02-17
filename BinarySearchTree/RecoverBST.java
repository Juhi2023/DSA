
class BST {
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
  
    //Brute Force : Traverse inorder and store node data in array then sort them and create BST from it
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    
    //Optimized : one traversal
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    Node first, middle, last, prev;

    public static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        if(prev!=null && prev.data> root.data){
            if(first==null){
                first=prev;
                middle = root;
            }else{
                last=root;
            }
        }
        prev=root;
        inorder(root.right);
    }

    public static BSTInfvoido recoverBST(Node root) {
        inorder(root);
        //swap first and last
        if(first!=null && last!=null){
            int temp = first.data;
            first.data = last.data;
            last.data= temp;
        }else if(first!=null && middle!=null){
            int temp = first.data;
            first.data = middle.data;
            middle.data= temp;
        }
        
    }


    public static void main(String[] args) {
 
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        BSTInfo ans = recoverBST(root);
      
        System.out.println(ans.size);
    }
}