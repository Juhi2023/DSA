
class BST {
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
  
    //Brute Force
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public static boolean isBST(Node root, int min, int max) {
        if(root==null)
            return true;

        if(min<root.data && root.data<max){
            return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
        }
        return false;
    }

    public static int size(Node root){
        if(root==null)
            return 0;
        return 1+ size(root.left)+size(root.right);
    }
    
    public static int largestBSTBrute(Node root) {
        if(root==null)
            return 0;
        
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return size(root);
        }
        return Math.max(largestBSTBrute(root.left), largestBSTBrute(root.right));
    }
    
    //Optimized
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static class BSTInfo{
        int size;
        int min;
        int max;
        BSTInfo(int min, int max, int s){
            this.min = min;
            this.max = max;
            size=s;
        }

    }

    public static BSTInfo largestBSTOptimized(Node root) {
        if(root==null)
            return new BSTInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        BSTInfo left = largestBSTOptimized(root.left);
        BSTInfo right = largestBSTOptimized(root.right);
        
        if(root.data> left.max && root.data < right.min){
            return new BSTInfo(Math.min(root.data, left.min), Math.max(root.data, right.max), 1+ left.size + right.size);
        }

        return new BSTInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }


    public static void main(String[] args) {
 
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        BSTInfo ans = largestBSTOptimized(root);
      
        System.out.println(ans.size);
    }
}