class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int count=0;
        int currSum=0;
        for(int num:nums){
            currSum+=num;
            if(currSum==k) count++;
            if(mp.containsKey(currSum-k)){
                count+=mp.get(currSum-k);
            }
            mp.put(currSum,mp.getOrDefault(currSum, 0)+1);
        }
        return count;
    }
}