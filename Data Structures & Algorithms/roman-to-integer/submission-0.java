class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> mp = new HashMap<>(){{
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }};
        int prev =0;
        int res=0;
        for(int i=s.length()-1;i>=0;i--){
            int curr = mp.get(s.charAt(i));
            if(prev>curr) {
                res-=curr;
            } else {
                res+=curr;
            }
            prev = curr;
        }
        return res;
    }
}