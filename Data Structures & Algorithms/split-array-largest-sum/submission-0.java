class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            sum+=nums[i];
        }
        int l = max;
        int h = sum;
        while(l<h){
            int m = l +(h-l)/2;
            if(possible(nums,m,k)){
                h=m;
            } else {
                l=m+1;
            }
        }
        return l;
    }
    public boolean possible(int[] nums,int capacity,int k){
        int count =1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>capacity){
                count+=1;
                sum=nums[i];
            }
        }
        return count<=k;
    }
}