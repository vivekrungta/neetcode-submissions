class Solution {
    public boolean isMatch(String s, String p) {
        int ns = s.length();
        int np = p.length();
        if(np==0) return ns==0;
        boolean dp[][] = new boolean[ns+1][np+1];
        dp[0][0]=true;
        for(int i=1;i<=np;i++){
            if(i>1 && p.charAt(i-1)=='*') {
                dp[0][i]=dp[0][i-2];
            }
        }
        for(int i=1;i<=ns;i++){
            for(int j=1;j<=np;j++){
                if(j>1 && p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2];
                    if(p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.'){
                        dp[i][j]|=dp[i-1][j];
                    }
                } else if (p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[ns][np];
    }
}
