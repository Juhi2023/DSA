
class BST {
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
  

    //Using inorder traversal save it in array then find position of that element using binary search
    //Time Complexity: O(N + log N)
    //Space Complexity: O(N)
    

    //using morris traversal
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static void getInorderSuccessorPredecessorByMoris(Node root, int key) {
        Node current = root;
        Node successor = null;
        Node predecessor = null;
        boolean found = false;

        while(current!=null){
            if(current.left==null){
                if(found && successor==null)
                    successor=current;
                if(key==current.data)
                    found=true;
                if(!found)
                    predecessor=current;
                current = current.right;
            }else{                
                Node prev = current.left;
                while(prev.right!=null && prev.right!=current)
                    prev=prev.right;
                if(prev.right==null){
                    prev.right=current;
                    current= current.left;
                }else{
                    if(found && successor==null)
                        successor=current;
                    if(key==current.data)
                        found=true;
                    if(!found)
                        predecessor=current;
                    current = current.right;
                    prev.right=null;
                }
            }
        }
        System.out.println(predecessor.data);
        System.out.println(successor.data);
    }

    //optimized
    //Time Complexity: O(h)
    //Space Complexity: O(1)
    public static Node rightMost(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static Node leftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public static void getInorderSuccessorPredecessorOptimized(Node root, int key) {
        Node curr = root;
        Node suc=null;
        Node pre=null;
        while (curr != null) {
            if (curr.data < key) {
                pre = curr;
                curr = curr.right;
            }
            else if (curr.data > key) {
                suc = curr;
                curr = curr.left;
            }
            else {
              
                if (curr.left != null)
                    pre = rightMost(curr.left);

                if (curr.right != null)
                    suc = leftMost(curr.right);
                break;
            }
        }
        System.out.println("Successor: " + suc.data);
        System.out.println("Predecessor: " + pre.data);
    }



    public static void main(String[] args) {
 
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        getInorderSuccessorPredecessorOptimized(root, 2);
    }
}