import java.util.*;

public class NaryTreePreorderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
    
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    private void helper(Node node, List<Integer> result) {
        if (node == null) return;
        
        result.add(node.val);
        if(node.children==null)
            return;

        for (Node child : node.children) {
            helper(child, result);
        }
    }
    
    public List<Integer> preorderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.val);
            
            if (current.children != null) {
                Collections.reverse(current.children);
                for (Node child : current.children) {
                    stack.push(child);
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));

        NaryTreePreorderTraversal solution = new NaryTreePreorderTraversal();
        System.out.println("Recursive: " + solution.preorder(root));
        System.out.println("Iterative: " + solution.preorderIterative(root));
    }
}
