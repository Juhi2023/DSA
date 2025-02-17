
class BST {
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
  

    //Using recursion
    //Time Complexity: O(h)
    //Space Complexity: O(h)
    public static int getLCAByRecursion(Node root, int a, int b) {
        if(root==null)
            return null;
        
        if(a<root.data && b<root.data)
            getLCAByRecursion(root.left, a, b);
        if(a>root.data && b>root.data)
            getLCAByRecursion(root.right, a, b);
        return root;
    }

    //using iteration
    //Time Complexity: O(h)
    //Space Complexity: O(1)
    public static int getLCA(Node root, int a, int b) {
        Node curr=root;
        while(curr!=null){
            int val = curr.data;
            if(a<val && b<val){
                curr=curr.left;
            }else if(a>val && b>val){
                curr=curr.right;
            }else{
                break;
            }
        }
        return curr.data;
    }



    public static void main(String[] args) {
 
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.println(getLCA(root, 3, 4));
    }
}