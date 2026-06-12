/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> memo = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        if(memo.get(node)!=null) return memo.get(node);
        Node res = new Node(node.val);
        memo.put(node,res);
        for(Node child:node.neighbors){
            res.neighbors.add(cloneGraph(child));
        }
        return res;
    }
}