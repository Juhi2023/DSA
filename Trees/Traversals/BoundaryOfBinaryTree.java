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

    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
    
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static void addLeftBoundary(List<Integer> res, Node node) {
        Node curr = node.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                res.add(curr.data);
            }
            if(curr.left!=null){
                curr = curr.left;
            }else{
                curr= curr.right;
            }
        }
        
    }
    
    public static void addLeaves(List<Integer> res, Node node) {
        if(isLeaf(curr)){
            res.add(node.data);
            return;
        }
        
        if(node.left!=null){
            addLeaves(res, node.left);
        }
        
        if(node.right!=null){
            addLeaves(res, node.right);
        }
        
    }
    
    public static void addRightBoundary(List<Integer> res, Node node) {    
        List<Integer> temp = new ArrayList<>();     
        Node curr = node.right;

        while(curr!=null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            if(curr.right!=null){
                curr = curr.right;
            }else{
                curr= curr.left;
            }
        }
        
        for(int i=temp.size()-1; i>=0; i--){
            res.add(temp.get(i));
        }
        
    }
    
    public static List<Integer> boundaryTraversal(Node node) {
        List<Integer> res = new ArrayList<>();
        if(node==null)
            return res;

        if (!isLeaf(root)) {
            res.add(root.data);
        }
            
        addLeftBoundary(res, node);
        addLeaves(res, node);
        addRightBoundary(res, node);
        return res;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(boundaryTraversal(root));
    }
}