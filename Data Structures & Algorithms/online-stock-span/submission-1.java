class StockSpanner {
    Stack<int[]> st;
    int i=0;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek()[1]<=price) st.pop();
        int res=st.isEmpty()?i+1:i-st.peek()[0];
        st.push(new int[]{i,price});
        i++;
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */