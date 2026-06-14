class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num:nums) sum+=num;
        int p=0;
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
            if(sum==p){
                return i;
            }
            p+=nums[i];
        }
        return -1;
    }
}