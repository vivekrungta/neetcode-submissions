class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        int l = max;
        int h = sum;
        while(l<h){
            int m = l +(h-l)/2;
            if(possible(weights,m,days)){
                h=m;
            } else {
                l=m+1;
            }
        }
        return l;

    }
    public boolean possible(int[] weights,int capacity,int days){
        int count =1;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(sum>capacity){
                count+=1;
                sum=weights[i];
            }
        }
        return count<=days;
    }

}