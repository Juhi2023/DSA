/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node dfs(Node node, HashMap<Node, Node> visited){
        Node temp = new Node(node.val);
        visited.put(node, temp);
        for(Node x: node.neighbors){
            if(visited.get(x)==null)
                temp.neighbors.add(dfs(x, visited));
            else 
                temp.neighbors.add(visited.get(x));
        }
        return temp;
    }

    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        HashMap<Node, Node> visited = new HashMap<>();        
        return dfs(node, visited);
    }
}