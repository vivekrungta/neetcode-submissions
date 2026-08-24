class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxf = nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp=min;
            min=Math.min(min*nums[i],Math.min(nums[i],max*nums[i]));
            max=Math.max(tmp*nums[i],Math.max(nums[i],max*nums[i]));
            maxf=Math.max(maxf,max);
        }
        return maxf;
    }
}
