class Solution {

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,target,0,res,new ArrayList<>());
        return res;
    }

    private void helper(int[] nums,int target,int start,List<List<Integer>> res, List<Integer> li){
        if(target==0){
            res.add(new ArrayList<>(li));
            return;
        }
        if(target<0) return;
        for(int i=start;i<nums.length;i++){
            if(target<nums[i]) break;
            if(i>start && nums[i]==nums[i-1]) continue;
            li.add(nums[i]);
            helper(nums,target-nums[i],i+1,res,li);
            li.remove(li.size()-1);
        }
    }
}
