
    import java.util.*;
class Tree {
    public static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    //Time Complexity: O(N) 
    //Space Complexity: O(N) 
    public static Node helper(int[] preorder, int preIndex[], int left, int right, HashMap<Integer, Integer> inorderMap) {
        if(left>right)
            return null;
        int curr = preorder[preIndex[0]];
        Node root = new Node(curr);
        int i = inorderMap.get(curr);
        preIndex[0]++;
        root.left = helper(preorder, preIndex, left,  i-1, inorderMap);
        root.right = helper(preorder, preIndex, i+1,  right, inorderMap);
        return root;
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        int preIndex[]={0};
        for(int i=0; i< inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder,preIndex,  0, inorder.length-1, inorderMap);
    }

    public static void printPostorder(Node root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] in = {3, 1, 4, 0, 5, 2};
        int[] pre = {0, 1, 3, 4, 2, 5};
        Node root = buildTree(pre, in);

        printPostorder(root);
    }
}