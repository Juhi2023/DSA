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

    //Time Complexity: O(2N * log N ) The time complexity arises from traversing the tree to create the parent hashmap, which involves visiting every node once hence O(N), exploring all nodes at a distance of ‘K’ which will be O(N) in the worst case, and the logarithmic lookup time for the hashmap is O( log N) in the worst scenario as well hence O(N + N + log N) which simplified to O(N).
    //Space Complexity: O(3N) 
    public static void makeParents(Node root, Map<Node, Node> parents){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left !=null){
                parents.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right !=null){
                parents.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        
    }
    public static List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parents = new HashMap<>();
        makeParents(root, parents);
        Queue<Node> q = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        q.add(target);
        visited.put(target, true);
        int dis=0;
        while(!q.isEmpty()){
            if(dis==k){
                break;
            }
            dis++;
            int size = q.size();

            for(int i=0; i< size; i++){
                Node temp = q.poll();
                if (temp.left != null && !visited.containsKey(temp.left)) {
                    q.add(temp.left);
                    visited.put(temp.left, true);
                }
                if (temp.right != null && !visited.containsKey(temp.right)) {
                    q.add(temp.right);
                    visited.put(temp.right, true);
                }
                Node tempP = parents.get(temp);
                if(parents.containsKey(temp) && !visited.containsKey(tempP)){
                    q.add(tempP);
                    visited.put(tempP, true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().data);
        }
        return res;
    }
    
    //recursive
    // static void dfs(Node root, Node prev, int k, Map<Node, Node> parent, ArrayList<Integer> ans) {

    //     if (root == null)
    //         return;
        
    //     if (k == 0) {
    //         ans.add(root.data);
    //         return;
    //     }

    //     if (root.left != prev)
    //         dfs(root.left, root, k - 1, parent, ans);

    //     if (root.right != prev)
    //         dfs(root.right, root, k - 1, parent, ans);

    //     if (parent.get(root) != prev)
    //         dfs(parent.get(root), root, k - 1, parent, ans);
    // }


    public static void main(String args[]){
        Node root = new Node(1);
        Node target = new Node(2);
        root.left = target;
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.left.right.left = new Node (8);
        root.left.right.right = new Node (9);
        root.right.left = new Node (6);
        root.right.right = new Node (7);

        System.out.println(distanceK(root, target, 2));
    }
}