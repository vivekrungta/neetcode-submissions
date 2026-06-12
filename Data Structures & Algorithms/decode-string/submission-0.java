class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();
        Stack<Integer> it = new Stack<>();
        int p=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                p=p*10+c-'0';
            } else if (c=='['){
                it.add(p);
                st.add(sb.toString());
                sb= new StringBuilder();
                p=0;
            } else if (c==']'){
                int count= it.pop();
                String last = st.pop();
                String curr = sb.toString();
                sb = new StringBuilder();
                sb.append(last);
                for(int j=0;j<count;j++){
                    sb.append(curr);
                }
                p=0;
            } else {
                sb.append(c);
            }

        }
        return sb.toString();

    }
}