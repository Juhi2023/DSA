
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

    public static int sum(Node root){
        if(root==null)
            return 0;
        return root.data+ sum(root.left)+sum(root.right);
    }
    
    public static int maxSumBST(Node root) {
        if(root==null)
            return 0;
        
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return sum(root);
        }
        return Math.max(maxSumBST(root.left), maxSumBST(root.right));
    }
    
    //Optimized
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static class BSTInfo{
        int sum;
        int min;
        int max;
        BSTInfo(int min, int max, int s){
            this.min = min;
            this.max = max;
            sum=s;
        }

    }
    public static int maxSum=0;

    public static BSTInfo maxSumBSTOptimized(Node root) {
        if(root==null)
            return new BSTInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        BSTInfo left = maxSumBSTOptimized(root.left);
        BSTInfo right = maxSumBSTOptimized(root.right);
        
        if(root.data> left.max && root.data < right.min){
            int currSum = root.data + left.sum + right.sum;
            maxSum= Math.max(maxSum, currSum);
            return new BSTInfo(Math.min(root.data, left.min), Math.max(root.data, right.max), currSum);
        }

        return new BSTInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
    }


    public static void main(String[] args) {
 
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        BSTInfo ans = maxSumBSTOptimized(root);
      
        System.out.println(maxSum);
    }
}