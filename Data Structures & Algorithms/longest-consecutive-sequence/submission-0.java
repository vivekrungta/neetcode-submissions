class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num:nums) st.add(num);
        int max=0;
        for(int num:nums){
            if(st.contains(num-1)) continue;
            int t =num;
            int count =0;
            while(st.contains(t)){
                st.remove(t);
                count++;
                t=t+1;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
