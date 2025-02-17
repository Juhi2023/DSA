class AVLTree{

    public static class Node {
        int data;
        Node left, right;
        int height;

        Node(int value) {
            data = value;
            left = right = null;
            height=1;
        }
    }

    public static Node root;

    public static int height(Node root){
        if(root==null)
            return 0;
        return root.height;
    }


    public static int balanceFactor(Node root){
        if(root==null)
            return 0;
        return height(root.left) - height(root.right);
    }


    public static Node rotateRight(Node x){
        Node y = x.left;
        Node temp = y.right;
        y.right = x;
        x.left = temp;

        //update height of x and y
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));        
        return y;
    }

    public static Node rotateLeft(Node x){
        Node y = x.right;
        Node temp = y.left;
        y.left = x;
        x.right = temp;

        //update height of x and y
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));        
        return y;
    }

    public static Node insert(Node root, int key){
        if(root==null)
            return new Node(key);
        if(key < root.data)
            root.left = insert(root.left, key);
        else if(key> root.data)
            root.right = insert(root.right, key);
        else
            return root;
        
        root.height = 1 + Math.max(height(root.left), height(root.right));

        int bf = balanceFactor(root);
        
        //R rotate with LL case
        if(bf>1 && key< root.left.data)
            return rotateRight(root);
        //L rotate with RR cas
        if(bf<-1 && key> root.right.data)
            return rotateLeft(root); 
        //LR case
        if(bf>1 && key > root.left.data){
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        //RL case
        if(bf<-1 && key < root.right.data){
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
    }

    public static Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            // node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = root.left != null ? root.left : root.right;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else 
                // One child case
                    root = temp; 
                } else {
                    // node with two children: Get the norder successor (smallest in the right subtree)
                    Node temp = minValueNode(root.right);

                    // Copy the inorder successor's  data to this node
                    root.data = temp.data;

                    // Delete the inorder successor
                    root.right = deleteNode(root.right, temp.data);
                }
            }

        // If the tree had only one node then return
        if (root == null)
            return root;

        //UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = balanceFactor(root);

        // Left Left Case
        if (balance > 1 && balanceFactor(root.left) >= 0)
            return rotateRight(root);

        // Left Right Case
        if (balance > 1 && balanceFactor(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Right Right Case
        if (balance < -1 && balanceFactor(root.right) <= 0)
            return rotateLeft(root);

        // Right Left Case
        if (balance < -1 && balanceFactor(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }


    public static void inorder(Node root) { 
        if (root != null) { 
            inorder(root.left); 
            System.out.print(root.data + " "); 
            inorder(root.right); 
        } 
    } 


    public static void main(String args[]){
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        deleteNode(root, 40);
        inorder(root);
    }
}