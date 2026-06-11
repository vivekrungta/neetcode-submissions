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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        // return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        Stack<TreeNode> st = new Stack<>();
        st.push(p);
        st.push(q);
        while(!st.isEmpty()){
            TreeNode x = st.pop();
            TreeNode y = st.pop();
            if(x==null && y==null) continue;
            if(x==null && y!=null) return false;
            if(x!=null && y==null) return false;
            if(x.val!=y.val) return false;
            st.push(x.left);
            st.push(y.left);
            st.push(x.right);
            st.push(y.right);
        }
        return true;
    }
}
