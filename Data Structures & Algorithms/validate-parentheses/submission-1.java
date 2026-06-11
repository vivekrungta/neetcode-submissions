class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if("[{(".indexOf(c)!=-1){
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                if(c==')' && st.peek()!='(') return false;
                if(c=='}' && st.peek()!='{') return false;
                if(c==']' && st.peek()!='[') return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
