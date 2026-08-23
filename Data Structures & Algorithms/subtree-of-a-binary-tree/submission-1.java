/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return serialize(root).contains(serialize(subRoot));
    }
    public String serialize(TreeNode root) {
    StringBuilder res = new StringBuilder();
    serialize(root, res);
    return res.toString();
}

private void serialize(TreeNode cur, StringBuilder res) {
    if (cur == null) {res.append(",#"); return;}
    res.append(","+cur.val);
    serialize(cur.left, res);
    serialize(cur.right, res);
}
}
