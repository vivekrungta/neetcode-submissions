class Solution {
    public int reverse(int x) {
        int sign =1;
        if(x<0){
            sign=-1;
            x=-x;
        }
        int res=0;
        while(x!=0){
            if((Integer.MAX_VALUE-(x%10))/10<res) return 0;
            res=res*10+(x%10);
            x=x/10;

        }
        return sign*res;
    }
}
