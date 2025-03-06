import java.util.*;

class CreateTree{

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            data=val;
            left=null;
            right=null;
        }
    }

    //Approach 1
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static boolean getPath(Node root, int n, List<Node> path){
        if(root==null){
            return false;
        }

        path.add(root);
        if(root.data==n){
            return true;
        }

        if(getPath(root.left, n, path) || getPath(root.right, n, path))
            return true;
        path.remove(path.size()-1);
        return false;
    }
    
    public static Node lowestCommonAncestor1(Node root, Node p, Node q) {
        if(root==null|| p==root || q==root)
            return root;
        List<Node> pPath = new ArrayList<>();
        List<Node> qPath = new ArrayList<>();
        getPath(root, p.data, pPath);
        getPath(root, q.data, qPath);
        Node lca=null;

        int i=0;
        for(; i<pPath.size() && i<qPath.size(); i++){
            if(pPath.get(i).data!=qPath.get(i).data)
                break;
        }
        lca = pPath.get(i-1);
        return lca;
    }

    //Recursive
    public Node lowestCommonAncestor2(Node root, Node p, Node q) {
        if(root==null || root==p || root==q)
            return root;
        
        Node left = lowestCommonAncestor2(root.left, p, q);
        Node right = lowestCommonAncestor2(root.right, p, q);

        if(left==null)
            return right;
        
        if(right==null)
            return left;
        return root;
    }
    

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        Node p = new Node (4);
        Node q = new Node (6);
        root.left.left = p;
        root.left.right = new Node (5);
        root.right.left = q;
        root.right.right = new Node (7);

        System.out.println(lowestCommonAncestor1(root, p, q));
    }
}