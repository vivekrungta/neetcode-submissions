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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode root,StringBuilder sb) {
        if(root==null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(q);
    }

    public TreeNode deserializeHelper(Queue<String> q) {
        if(q.isEmpty()) {
            return null;
        }
        String s = q.poll();
        if(s.equals("#")) return null;
        TreeNode res = new TreeNode(Integer.valueOf(s));
        res.left = deserializeHelper(q);
        res.right = deserializeHelper(q);
        return res;
    }
}
