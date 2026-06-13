class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] ca = s.toCharArray();
        int index[] = new int[26];
        for(int i=0;i<ca.length;i++){
            index[ca[i]-'a']=i;
        }
        List<Integer> res= new ArrayList<>();
        int start=0;
        int max=0;
        for(int i=0;i<ca.length;i++){
            max=Math.max(max,index[ca[i]-'a']);
            if(max==i){
                res.add(i-start+1);
                start=i+1;
            }
        }
        return res;
    }
}
