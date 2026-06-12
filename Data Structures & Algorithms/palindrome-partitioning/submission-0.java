class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp=new boolean[s.length()][s.length()];
        partitionHelper(s,0,res,new ArrayList<>(),dp);
        return res;
    }

    public void partitionHelper(String s,int start,List<List<String>> res,List<String> li,boolean[][] dp){
        if(start>=s.length()){
            res.add(new ArrayList<>(li));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(s.charAt(start)==s.charAt(end) && (end-start<=2 || dp[start+1][end-1])){
                dp[start][end]=true;
                li.add(s.substring(start,end+1));
                partitionHelper(s,end+1,res,li,dp);
                li.remove(li.size()-1);
            }
        }
    }
}
