class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 1;
        for(int pile:piles){
            max=Math.max(max,pile);
        }

        int p =1;
        int q = max;
        while(p<q){
            int m = p+(q-p)/2;
            if(canEat(piles,m,h)){
                q=m;
            } else {
                p=m+1;
            }
        }
        return p;
    }
    public boolean canEat(int[] piles,int m, int h){
        int hour=0;
        for(int pile:piles){
            hour+=pile/m;
            hour+=(pile%m)==0?0:1;
        }
        return hour<=h;
    }
}
