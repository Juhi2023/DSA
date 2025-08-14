//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/

class Solution {
    public void helper(TreeNode root, int length, int ans[], int dir) {
        if(root==null){
            return;
        }
        ans[0] = Math.max(ans[0], length);
        if(dir==-1){
            helper(root.right, length+1, ans, +1);
            helper(root.left, 1, ans, -1);
        }else{
            helper(root.left, length+1, ans, -1);
            helper(root.right, 1, ans, +1);
        }
    }

    public int longestZigZag(TreeNode root) {
        int ans[]={0};
        helper(root, 0, ans, -1);
        return ans[0];
    }
}