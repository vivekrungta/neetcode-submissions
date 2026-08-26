class Solution {
    Map<Character,String> mp;
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null ||digits.length()==0) return res;
        mp = new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        
        helper(digits,0,res,new StringBuilder());
        return res;
    }

    public void helper(String digits,int index,List<String> res,StringBuilder sb){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        String s = mp.get(digits.charAt(index));
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            helper(digits,index+1,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
