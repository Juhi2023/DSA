//https://leetcode.com/problems/binary-tree-cameras/description/

class Solution {
    int res=0;
    public int helper(TreeNode root) {
        if(root==null)
            return 1;
        
        int l = helper(root.left);
        int r = helper(root.right);

        if(l==0 || r==0){
            res++;
            return 2;
        }
        if(l==2 || r==2)
            return 1;

        return 0;
    }
    public int minCameraCover(TreeNode root) {
        if (helper(root) == 0) {
            res++;
        }
        return res;
    }
}