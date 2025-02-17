import java.util.*;

public class MaximumDepthOfNAryTree {
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
    
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        int max=0;
        if(root.children!=null)
            for(int i=0; i<root.children.size(); i++){
                max= Math.max(max, maxDepth(root.children.get(i)));
            }
        return 1+max;
    }

    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));

        MaximumDepthOfNAryTree solution = new MaximumDepthOfNAryTree();
        System.out.println("Depth: " + solution.maxDepth(root));
    }
}
