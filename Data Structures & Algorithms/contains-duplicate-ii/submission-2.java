class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        int start=0;
        for(int num:nums){
            if(st.contains(num)) return true;
             st.add(num);
            if(st.size()>k) st.remove(nums[start++]);
            
        }
        return false;

    }
}