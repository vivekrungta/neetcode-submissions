class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1=null;
        Integer candidate2=null;
        int cnt1=0;
        int cnt2=0;
        for(int num:nums){
            if(candidate1!=null && candidate1==num){
                cnt1++;
            } else if(candidate2!=null && candidate2==num){
                cnt2++;
            } else if (cnt1==0){
                cnt1++;
                candidate1=num;
            } else if (cnt2==0){
                cnt2++;
                candidate2=num;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int num:nums){
            if(candidate1!=null && num==candidate1) cnt1++;
            if(candidate2!=null && num==candidate2) cnt2++;
        }
        List<Integer> res = new ArrayList<>();
        if(cnt1>nums.length/3) res.add(candidate1);
        if(cnt2>nums.length/3) res.add(candidate2);
        return res;
    }
}