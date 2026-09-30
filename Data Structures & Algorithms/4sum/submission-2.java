class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            if(j>0 && nums[j]==nums[j-1]) continue;
            for(int i=j+1;i<nums.length;i++){
                if(i>j+1 && nums[i]==nums[i-1]) continue;
                int l =i+1;
                int h = nums.length-1;
                while(l<h){
                    if((long)nums[j]+nums[i]+nums[l]+nums[h]==target) {
                        res.add(Arrays.asList(nums[j],nums[i],nums[l],nums[h]));
                        l++;
                        h--;
                        while(l<h && nums[l]==nums[l-1]) l++;
                        while(l<h && nums[h]==nums[h+1]) h--;
                    } else if (nums[j]+nums[i]+nums[l]+nums[h]< target) {
                        l++;
                    } else {
                        h--;
                    }
                }
            }
        }
        return res;
    }
}