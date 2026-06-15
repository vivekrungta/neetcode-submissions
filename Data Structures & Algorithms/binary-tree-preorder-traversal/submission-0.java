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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.add(curr);
                res.add(curr.val);
                curr=curr.left;
            }
            TreeNode popped = st.pop();
            curr = popped.right;
        }
        return res;
    }
}