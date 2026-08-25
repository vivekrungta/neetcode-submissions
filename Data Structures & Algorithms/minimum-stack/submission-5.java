class MinStack {

    Stack<Integer> st;
    Stack<int[]> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        if(minSt.isEmpty() || minSt.peek()[0]>val) minSt.push(new int[]{val,1});
        else if(minSt.peek()[0]==val) minSt.peek()[1]++;
        st.push(val);
    }
    
    public void pop() {
        if(minSt.peek()[0]==st.peek()) minSt.peek()[1]--;
        if(minSt.peek()[1]==0) minSt.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek()[0];
    }
}
