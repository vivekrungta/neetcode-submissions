class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%k!=0) return false;
        int targetSum = sum/k;
        char[] taken = new char[nums.length];
        Arrays.fill(taken,'0');
        Arrays.sort(nums);
        reverse(nums);
        Map<String,Boolean> memo = new HashMap<>();
        return helper(nums,0,0,0,k,taken,targetSum,memo);
    }
    public void reverse(int[] nums){
        int l=0;
        int h = nums.length-1;
        while(l<h){
            int tmp=nums[l];
            nums[l]=nums[h];
            nums[h]=tmp;
            l++;
            h--;
        }

    }

    public boolean helper(int[] nums,int index,int count,int currSum,int k,char[] taken,int targetSum,Map<String,Boolean> memo){
        if(count==k-1){
            return true;
        }
        if(currSum>targetSum) return false;
        String takenStr = new String(taken);
        if(memo.containsKey(takenStr)){
            return memo.get(takenStr);
        }
        if(currSum==targetSum) {
            boolean ans = helper(nums,0,count+1,0,k,taken,targetSum,memo);
            memo.put(takenStr, ans);
            return ans;
        }
        boolean res = false;
        for(int i=index;i<nums.length;i++){
            if(taken[i]=='0'){
                taken[i]='1';
                if(helper(nums,i+1,count,currSum+nums[i],k,taken,targetSum,memo)) {
                    res = true;
                   
                   break;
                }
                taken[i]='0';
            }
        }
        memo.put(takenStr,res);
        return res;
    }
}