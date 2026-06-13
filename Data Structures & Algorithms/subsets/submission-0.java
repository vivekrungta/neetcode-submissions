class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        int total= 1<<nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=1;i<total;i++){
            List<Integer> li = new ArrayList<>();
            res.add(li);
            int k=1;
            for(int j=0;j<nums.length;j++){
                if((k&i)!=0){
                    li.add(nums[j]);
                }
                k=k<<1;
            }
        }
        return res;

    }
}
