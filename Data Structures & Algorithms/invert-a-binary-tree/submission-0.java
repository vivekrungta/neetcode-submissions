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
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node==null) continue;
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right=tmp;
            st.add(node.left);
            st.add(node.right);
        }
        return root;
    }
}
