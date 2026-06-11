class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token:tokens){
            if(!"+-/*".contains(token)){
                st.push(Integer.valueOf(token));
            }else {
                int x = st.pop();
                int y = st.pop();
                if(token.equals("+")) st.push(y+x);
                if(token.equals("-")) st.push(y-x);
                if(token.equals("/")) st.push(y/x);
                if(token.equals("*")) st.push(y*x);
            }
        }
        return st.pop();
    }
}
