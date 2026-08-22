class Solution {
    public int characterReplacement(String s, int k) {
        int start =0;
        Map<Character,Integer> mp = new HashMap<>();
        int max=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
            max=Math.max(max,mp.get(c));
            while(i-start+1-max>k){
                char oldC = s.charAt(start);
                mp.put(oldC,mp.getOrDefault(oldC, 0)-1);
                start++;
            }
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}
