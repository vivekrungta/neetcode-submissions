class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,0,0,new StringBuilder(),res);
        return res;
    }
    public void helper(int n,int open,int close,StringBuilder sb,List<String> res){
        if(close==n){
            res.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("(");
            helper(n,open+1,close,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            helper(n,open,close+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
