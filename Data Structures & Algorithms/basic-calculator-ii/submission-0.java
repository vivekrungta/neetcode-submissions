class Solution {
    public int calculate(String s) {
        int p =0;
        char operator = '+';
        int prev=0;
        int sum=0;
        s=s+"@";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                p=p*10+(c-'0');
            } else if(c!=' '){
                if(operator=='+'){
                    prev=prev+p;
                } else if(operator=='-'){
                    prev=prev-p;
                }else if(operator=='*'){
                    prev=prev*p;
                } else if(operator=='/'){
                    prev=prev/p;
                }
                p=0;
                operator=c;
                if(operator=='+' || operator=='-'){
                    sum+=prev;
                    prev=0;
                }
            }
        }
        return sum+prev;
    }
}