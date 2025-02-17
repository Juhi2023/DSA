/* https://leetcode.com/problems/construct-quad-tree/description/

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node helper(int[][] grid, int x, int y, int gridLength) {
        if(isAllSame(grid, x, y, gridLength)){
            return new Node(grid[x][y]==1 ? true : false, true);
        }
        Node root = new Node(true, false);
        root.topLeft = helper(grid, x, y, gridLength/2);
        root.topRight = helper(grid, x, y+gridLength/2, gridLength/2);
        root.bottomLeft  = helper(grid, x+gridLength/2, y, gridLength/2);
        root.bottomRight  = helper(grid, x+gridLength/2, y+gridLength/2, gridLength/2);
        return root;
    }

    public boolean isAllSame(int[][] grid, int x, int y, int length) {
        int item = grid[x][y];
        for(int i=x; i<x + length; i++){
            for(int j=y; j<y + length; j++){
                if(item != grid[i][j])
                    return false;
            }
        }
        return true;
    }

    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }
}