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
  
    //Brute Force : Traverse both tree in  inorder and store node data in array then merge both array and then generate BST from it
    //Time Complexity: O(n+m)
    //Space Complexity: O(n)
    public static Node sortedArrayToBSTRecur(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;    
        Node root = new Node(arr[mid]);    
        root.left = sortedArrayToBSTRecur(arr, start, mid - 1);
        root.right = sortedArrayToBSTRecur(arr, mid + 1, end);
    
        return root;
    }

    public static Node mergeBST(Node root1, Node root2){
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        inOrderTraversl(root1, arr1);
        inOrderTraversl(root2, arr2);
        List<Integer> arr = new ArrayList<>();
        int i=0, j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                arr.add(arr1.get(i));
                i++;
            }else{
                arr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            arr.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size()){
            arr.add(arr2.get(j));
            j++;
        }

        int[] array = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            array[k] = arr.get(k);
        }
        return sortedArrayToBSTRecur(array, 0, arr.size()-1);
    }
    
    //Optimized : BST iterator (using stack)
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public static Node mergeBSTUsingIterator(Node root1, Node root2) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        while(root1!=null || root2!=null || !st1.isEmpty() || st2.isEmpty()){
            while(root1!=null){
                st1.push(root1);
                root1= root1.left;
            }

            while(root2!=null){
                st2.push(root2);
                root2= root2.left;
            }

            if(st2.isEmpty() || (!st1.isEmpty() && st1.peek().data<=st2.peek().data)){
                root1 = st1.pop();
                arr.add(root1.data);
                root1 = root1.right;
            }else{
                root2 = st2.pop();
                arr.add(root2.data);
                root2 = root2.right;
            }
        }
        int[] array = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            array[k] = arr.get(k);
        }
        return sortedArrayToBSTRecur(array, 0, arr.size()-1);
    }


    public static void inOrderTraversl(Node root, List<Integer> ans){
        if(root==null){
            return ;
        }
        inOrderTraversl(root.left, ans);
        ans.add(root.data);
        inOrderTraversl(root.right, ans);
    }



    public static void main(String[] args) {
 
        Node root1 = new Node(4);
        root1.left = new Node(2);
        root1.right = new Node(5);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);

        Node root2 = new Node(14);
        root2.left = new Node(12);
        root2.right = new Node(15);
        root2.left.left = new Node(0);
        root2.left.right = new Node(13);

        Node root = mergeBST(root1, root2);
        List<Integer> ans = new ArrayList<>();
        inOrderTraversl(root, ans);
        System.out.println(ans);
    }
}

