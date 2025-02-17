import  java.util.*;
class BST {
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
  
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public static Node insertBST(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (root.data > key)
            root.left = insertBST(root.left, key);
        else if (root.data < key)
            root.right = insertBST(root.right, key);
        return root;
    }

    public static Node constructByNaive(List<Integer> pre) {
        Node root = null;

        for (int key : pre) {
            root = insertBST(root, key);
        }
        return root;
    }

    //using sort to get inorder traversal then construct BT
    //Time Complexity: O(n * log n)
    //Space Complexity: O()
    
    //Using Min and Max
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public Node constructByMinMax(List<Integer> pre, int index[], long max) {
        if(pre.length==index[0] || max<pre.get(index[0])){
            return null;
        }
        int val=pre.get(index[0]++);
        Node root = new Node(val);
        root.left = constructByMinMax(pre, index, val);
        root.right = constructByMinMax(pre, index, max);
        return root;
    }



    public static void main(String[] args) {

        List<Integer> pre = Arrays.asList(10, 5, 1, 7, 40, 50);
        int index[]={0};
        Node root = constructByMinMax(pre, index, Long.MAX_VALUE);
    }
}