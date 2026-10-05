class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int matchStick:matchsticks){
            sum+=matchStick;
        }
        if(sum%4!=0) return false;
        int length = sum/4;
        Arrays.sort(matchsticks);
        int[] sides=new int[4];
        return dfs(matchsticks,matchsticks.length-1,sides,length);
    }
    public Boolean dfs(int[] matchsticks,int index,int[] sides,int length){
        if(index<0){
            return true;
        }
        for(int i=0;i<4;i++){
            if(sides[i]+matchsticks[index]<=length){
                sides[i]+=matchsticks[index];
                if(dfs(matchsticks,index-1,sides,length)) return true;
                sides[i]-=matchsticks[index];
            }
            if (sides[i] == 0)
                break;
        }
        return false;
    }
}