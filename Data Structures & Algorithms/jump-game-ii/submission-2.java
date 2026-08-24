class Solution {
    public int jump(int[] nums) {
        int max_jump = 0;
        int curr_jump =0;
        int jump=0;
        for(int i=0;i<nums.length-1;i++){
            curr_jump = Math.max(curr_jump,nums[i]+i);
            if(max_jump==i){
                jump++;
                max_jump =curr_jump;
            }
        }
        return jump;
    }
}
