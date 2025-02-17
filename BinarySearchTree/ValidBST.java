
class BST {
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
  
    //Using Min and Max
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public boolean helper(Node root, long min, long max) {
        if(root==null)
            return true;

        if(min<root.val && root.val<max){
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }
        return false;
    }
    
    public static boolean isValidBST(Node root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //Using Inorder traversal and save it in array if it is in accending order then it is BST
    //Time Complexity: O(n)
    //Space Complexity: O(n)

    //using moris inorder
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static boolean isValidBSTByMorris(Node root) {
        Node curr=root; 
        long prev = Long.MIN_VALUE;

        while(curr!=null){
            if(curr.left==null){
                if(curr.val<=prev)
                    return false;
                    prev=curr.val;
                curr=curr.right;
            }else{
                Node temp = curr.left;
                while(temp.right!=null && temp.right!=curr)
                    temp=temp.right;
                
                if(temp.right==null){
                    temp.right = curr;
                    curr=curr.left;
                }else{
                    if (curr.val <= prev) {
                        return false;
                    }
                    prev=curr.val;
                    temp.right=null;
                    curr=curr.right;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
 
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
      
          if (isBST(root)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}