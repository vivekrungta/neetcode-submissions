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
    
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0]=Integer.MIN_VALUE;
        helper(root,res);
        return res[0];
    }

    public int helper(TreeNode root,int[] res) {
        if(root==null) return 0;
        int left = helper(root.left,res);
        int right = helper(root.right,res);
        int maxLeft = Math.max(root.val,root.val+left);
        int maxRight = Math.max(root.val,root.val+right);
        int returnMax = Math.max(maxLeft,maxRight);
        res[0] = Math.max(res[0],Math.max(returnMax,left+right+root.val));
        return returnMax;
    }
}
