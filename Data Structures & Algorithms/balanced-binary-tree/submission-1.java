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
    
    public boolean isBalanced(TreeNode root) {
        return helper(root)[1]==0;
    }
    public int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int balance = left[1]==0 && right[1]==0 && Math.abs(left[0]-right[0])<=1?0:1;
        int height = left[0]>right[0]?left[0]+1:right[0]+1;
        return new int[]{height,balance};
    }
}
