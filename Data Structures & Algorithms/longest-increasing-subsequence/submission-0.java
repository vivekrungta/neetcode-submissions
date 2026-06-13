class Solution {
    public int lengthOfLIS(int[] nums) {
        int n =nums.length;
        int dp[]= new int[n];
        dp[0]=nums[0];
        int max=1;
        for(int i=1;i<n;i++){
            int p = searchPos(dp,0,max-1,nums[i]);
            if(p==max){
                max++;
            }
            dp[p]=nums[i];
        }
        return max;
    }

    public int searchPos(int[] nums,int l,int h,int t){
        while(l<=h){
            int m= l+(h-l)/2;
            if(nums[m]==t) {return m;}
            else if(nums[m]<t) {
                l=m+1;
            }
            else {
h=m-1;
            }
        }
        return l;
    }
}
