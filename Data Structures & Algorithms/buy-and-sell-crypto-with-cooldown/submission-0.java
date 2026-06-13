class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices,0,0,0,new Integer[prices.length][2][2]);
    }
    public int helper(int[] prices,int i,int hold,int cooldown,Integer[][][] state){
        if(i==prices.length) return 0;
        if(state[i][hold][cooldown]!=null) return state[i][hold][cooldown];
        int something=0;
        int donothing =0;
        if(cooldown==1){
            something = helper(prices,i+1,hold,0,state);
            state[i][hold][cooldown] =something;
        } else {
            donothing = helper(prices,i+1,hold,cooldown,state);
            if(hold==1){
                something = prices[i]+helper(prices,i+1,0,1,state);
            } else {
                something = -prices[i]+helper(prices,i+1,1,0,state);
            }
            state[i][hold][cooldown] = Math.max(something,donothing);
        }
        return state[i][hold][cooldown];
    }
}
