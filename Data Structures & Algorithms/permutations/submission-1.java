class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,res);
        return res;
    }
    public void helper(int[] nums,int start,List<List<Integer>> res) {
        if(start==nums.length){
            List<Integer> li = new ArrayList<>();
            for(int num:nums) li.add(num);
            res.add(li);
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            helper(nums,start+1,res);
            swap(nums,start,i);
        }
    }

    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }

}
