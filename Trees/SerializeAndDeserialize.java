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

    //using Level order traversal
    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        String s="";
        if(root==null)
            return s;

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr!=null){
                s+=curr.data+",";
                q.offer(curr.left);
                q.offer(curr.right);
            }else{
                s+="X,";
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if(data.equals("")) 
            return null;
        String[] values = data.split(",");
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        q.offer(root);
        int i=1;

        while(!q.isEmpty()){
            Node curr = q.poll();
            if (!values[i].equals("X")) {
                curr.left = new Node(Integer.parseInt(values[i]));
                q.offer(curr.left);
            }
            i++;

            if (!values[i].equals("X")) {
                curr.right = new Node(Integer.parseInt(values[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }


    //Using Preorder
    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        if(root==null)
            return "X,";
        StringBuilder s=new StringBuilder();
        s.append(root.val+",");
        s.append(serialize(root.left));
        s.append(serialize(root.right));
        System.out.println(s);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode helper(String values[], int index[]) {
        if(values[index[0]].equals("X")) 
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        root.left = helper(values, index);
        index[0]++;
        root.right = helper(values, index);
        return root;
    }
    
    public TreeNode deserialize(String data) {
        if(data.equals("")) 
            return null;
        String values[] = data.split(",");
        int index[]={0};
        return helper(values, index);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(serialize(root));
    }
}