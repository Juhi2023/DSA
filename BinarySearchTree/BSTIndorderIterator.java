                                
import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class BSTIterator {
    private Stack<Node> myStack;

    BSTIterator(Node root) {
        myStack = new Stack<>();
        pushAll(root);
    }


    boolean hasNext() {
        return !myStack.isEmpty();
    }

    int next() {
        Node tmpNode = myStack.pop();
        pushAll(tmpNode.right);
        return tmpNode.data;
    }

    private void pushAll(Node node) {
        while (node != null) {
            myStack.push(node);
            node = node.left;
        }
    }
}

public class Main {
    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);
        
        System.out.print("Tree Initialized: ");
        printInOrder(root);
        System.out.println();
    
        BSTIterator bstIterator = new BSTIterator(root);
        
        System.out.println("Functions Called:");
        System.out.println("BSTIterator()");
        System.out.println("next(): " + bstIterator.next());
        System.out.println("next(): " + bstIterator.next());
        System.out.println("hasNext(): " + (bstIterator.hasNext() ? "true" : "false"));
        System.out.println("next(): " + bstIterator.next());
        System.out.println("hasNext(): " + (bstIterator.hasNext() ? "true" : "false"));
        System.out.println("next(): " + bstIterator.next());
        System.out.println("hasNext(): " + (bstIterator.hasNext() ? "true" : "false"));
        System.out.println("next(): " + bstIterator.next());
        System.out.println("hasNext(): " + (bstIterator.hasNext() ? "true" : "false"));
    }
}
                                
                            