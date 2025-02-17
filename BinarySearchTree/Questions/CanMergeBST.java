import java.util.*;


public class MergeBSTs {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public Node canMerge(List<Node> trees) {
        // Step 1: Collect all leaf node values in a set
        Set<Integer> leafNodes = new HashSet<>();

        for(Node node : trees){

            if(node.left != null){
                leafNodes.add(node.left.data);
            }

            if(node.right != null){
                leafNodes.add(node.right.data);
            }

        }

        // Step 2: Find the root node for the final BST
        Node root = null;
        for(Node node : trees){
            if(!leafNodes.contains(node.data)){ 
                root = node;
            }
        }

        // If no root is found, merging is not possible
        if(root == null){
            return null;
        }


        // Step 3: Add all other trees to a map for quick lookup by their root values
         Map<Integer,Node> rootNodes = new HashMap<>();
        for(Node node : trees){
            if(node != root){ // Skip the identified root
                rootNodes.put(node.data,node);
            }
        }

        // Step 4: Merge all subtrees into the root tree
        root = mergeBST(root,rootNodes);

        // Step 5: Validate the merged tree and check if all subtrees are used
        if(validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) && rootNodes.size() == 0){
            return root;
        }

        // Return null if the tree is not a valid BST or if some subtrees are unused
        return null;
    }

    Node mergeBST(Node root,Map<Integer,Node> rootNodes){

        if(root == null){
            return null;
        }

        // If current node matches a subtree root, merge the subtree
        if(rootNodes.containsKey(root.data)){
            Node node = rootNodes.get(root.data);

            root.left = node.left;
            root.right = node.right;

            rootNodes.remove(root.data);

        }

        root.left = mergeBST(root.left,rootNodes);
        root.right = mergeBST(root.right,rootNodes);

        return root;
    }

    boolean validateBST(Node root, long min, long max) {
        if(root==null)
            return true;

        if(min<root.data && root.data<max){
            return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
        }
        return false;
    }




    //other way 
    //merge + validation function
    // private boolean merge(Node node, Map<Integer, Node> rootMap, int min, int max) {
    //     if (node == null) return true;
    //     if (node.data <= min || node.data >= max) return false;

    //     if (node.left == null && node.right == null && rootMap.containsKey(node.data)) {
    //         Node subtree = rootMap.remove(node.data);
    //         node.left = subtree.left;
    //         node.right = subtree.right;
    //     }

    //     return merge(node.left, rootMap, min, node.data) && merge(node.right, rootMap, node.data, max);
    // }

    public static void main(String[] args) {
        Node tree1 = new Node(2);
        tree1.left = new Node(1);

        Node tree2 = new Node(3);
        tree2.left = new Node(2);
        tree2.right = new Node(5);

        Node tree3 = new Node(5);
        tree3.left = new Node(4);

        List<Node> trees = Arrays.asList(tree1, tree2, tree3);

        MergeBSTs solution = new MergeBSTs();
        Node result = solution.canMerge(trees);

        if (result != null) {
            System.out.println("Merged BST root: " + result.data);
        } else {
            System.out.println("Cannot merge BSTs into a single valid BST.");
        }
    }
}
