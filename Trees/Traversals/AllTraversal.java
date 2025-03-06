import java.util.*;

class createTree{

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

    public static class Pair{
        public Node key;
        public Integer value;

        Pair(Node key, int value){
            this.key = key;
            this.value = value;
        }
    }

    //Time Complexity: O(3N)
    //Space Complexity: O(4N)
    public static void traverse(Node root){
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) {
            return;
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while(!st.isEmpty()){
            Pair p = st.pop();

            if(p.value==1){
                pre.add(p.key.data);
                p.value =2;
                st.push(p);

                if (p.key.left != null) {
                    st.push(new Pair(p.key.left, 1));
                }
            }else if(p.value==2){
                in.add(p.key.data);
                p.value = 3;
                st.push(p);

                if (p.key.right != null) {
                    st.push(new Pair(p.key.right, 1));
                }
            }else{
                post.add(p.key.data);
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        traverse(root);
    }
}
