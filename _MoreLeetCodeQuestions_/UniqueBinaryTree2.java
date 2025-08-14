// https://leetcode.com/problems/unique-binary-search-trees-ii/description/

// Time Complexity: O(Cn​ * n), where Cn​ is the Catalan number
// Auxiliary Space: O(Cn​ * n)

class Solution {
    public List<TreeNode> helper(int start, int end,  Map<String, List<TreeNode>> memo ) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        if(memo.containsKey(start+","+end))
            return memo.get(start+","+end);
        
        for(int i=start; i<=end; i++){
            List<TreeNode> left = helper(start, i-1, memo);
            List<TreeNode> right = helper(i+1, end, memo);
            for(TreeNode l : left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i, l, r);
                    res.add(root);
                }
            }
        }
        memo.put(start+","+end, res);
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        Map<String, List<TreeNode>> memo = new HashMap<>();
        return helper(1, n, memo);
    }
}