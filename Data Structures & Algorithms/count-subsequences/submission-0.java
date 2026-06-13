class Solution {
    public int numDistinct(String s, String t) {
        return helper(s,t,0,0,new Integer[s.length()][t.length()]);
    }
    public int helper(String s, String t,int i,int j, Integer memo[][]){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(memo[i][j]!=null) return memo[i][j];
        int ans = helper(s,t,i+1,j,memo);
        if(s.charAt(i)==t.charAt(j)){
            ans+=helper(s,t,i+1,j+1,memo);
        }
        memo[i][j]=ans;        
        return ans;

    }
}
