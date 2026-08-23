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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if(root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int maxLeft = Math.max(root.val,root.val+left);
        int maxRight = Math.max(root.val,root.val+right);
        int returnMax = Math.max(maxLeft,maxRight);
        max = Math.max(max,Math.max(returnMax,left+right+root.val));
        return returnMax;
    }
}
