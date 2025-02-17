
class BST {
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
  

    //using inorder
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public void inorder(List<Integer> arr, Node root){
    if(root==null)
            return;
        inorder(arr, root.left);
        arr.add(root.data);
        inorder(arr, root.right);
    }

    public Node createBST(List<Integer> arr, int low, int high){
        if(low>high){
            return null;
        }
        int mid = (low+high)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, low, mid-1);
        root.right = createBST(arr, mid+1, high);
        return root;
    }

    public Node balanceBST(Node root) {
        List<Integer> node = new ArrayList<>();
        inorder(node, root);
        return createBST(node, 0, node.size()-1);
    }


    //using moris inorder
    //Time Complexity: O(n)
    //Space Complexity: O(h)



    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(5);
        root.left.left.left = new Node(1);
        root.left.left.left = new Node(3);
      
        balanceBST(root);
    }
}