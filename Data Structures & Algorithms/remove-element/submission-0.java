class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int num:nums){
            if(num!=val){
                nums[j++]=num;
            }
        }
        return j;
    }
}