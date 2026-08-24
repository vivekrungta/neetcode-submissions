class Solution {
    public boolean checkValidString(String s) {
        int openMin =0;int openMax=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                openMax++;
                openMin++;
            } else if(s.charAt(i)==')'){
                openMax--;
                openMin--;
            } else {
                openMax++;
                openMin--;
            }
            if(openMax<0) return false;
            openMin = openMin<0?0:openMin;
        }
        return openMin==0;
    }
}
