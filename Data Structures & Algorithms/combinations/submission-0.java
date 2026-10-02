class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1,n,k,res,new ArrayList<>());
        return res;
    }
    public void helper(int s, int n,int k,List<List<Integer>> res,List<Integer> li){
        if(k==0){
            res.add(new ArrayList<>(li));
            return;
        }
        for(int i=s;i<=n;i++){
            li.add(i);
            helper(i+1,n,k-1,res,li);
            li.remove(li.size()-1);
        }



    }

}