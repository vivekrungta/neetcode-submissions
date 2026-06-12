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
    int pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,0,inorder.length-1,mp);

    }
    public TreeNode buildTreeHelper(int[] preorder,int l,int h,Map<Integer,Integer> mp){
        if(l>h) return null;
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = buildTreeHelper(preorder,l,mp.get(node.val)-1,mp);
        node.right = buildTreeHelper(preorder,mp.get(node.val)+1,h,mp);
        return node;
    }
}
