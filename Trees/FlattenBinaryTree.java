
class BinaryTree {
    public static class Node {
        int data;
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }

	Node root;

    //recursive
    //Time Complexity: O(N)
    //Space Complexity: O(N)
	public static void flatten(Node node){
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			return;

		if (node.left != null) {
			flatten(node.left);
			Node tempNode = node.right;
			node.right = node.left;
			node.left = null;
			Node curr = node.right;
			while (curr.right != null)
				curr = curr.right;
			curr.right = tempNode;
		}
		flatten(node.right);
	}

    //iterative
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public void flattenByStack(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
            if(!st.isEmpty()){
                TreeNode peek = st.peek();
                curr.right= peek;
            }
            curr.left=null;
        }
    }

    //by morris
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public void flattenByMorris(TreeNode root) {
        if(root==null)
            return;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode temp = curr.left;
                while(temp.right!=null)
                    temp=temp.right;
                temp.right = curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }

	public void inOrder(Node node){
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.right = new Node(6);

		System.out.println("The Inorder traversal after flattening binary tree ");
		tree.flatten(tree.root);
		tree.inOrder(tree.root);
	}
}