class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0]=1;
        newNums[nums.length+1]=1;
        for(int i=0;i<nums.length;i++){
            newNums[i+1]=nums[i];
        }
        return helper(newNums,1,newNums.length-2,new Integer[newNums.length][newNums.length]);
    }

    private int helper(int[] nums,int l,int h,Integer[][] memo){
        if(l>h) return 0;
        if(memo[l][h]!=null) return memo[l][h];
        int max =0;
        for(int i=l;i<=h;i++){
            int sum=nums[l-1]*nums[i]*nums[h+1];
            sum+=helper(nums,l,i-1,memo)+helper(nums,i+1,h,memo);
            max=Math.max(max,sum);
        }
        memo[l][h]=max;
        return max;
    }
}
