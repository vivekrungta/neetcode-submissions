class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            String s = operations[i];
            if(s.equals("+")){
                int x =st.pop();
                int y = st.pop();
                st.push(y);
                st.push(x);
                st.push(x+y);
            } else if (s.equals("C")){
                st.pop();
            } else if (s.equals("D")){
                st.push(2*st.peek());
            } else {
                st.push(Integer.valueOf(s));
            }

        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}