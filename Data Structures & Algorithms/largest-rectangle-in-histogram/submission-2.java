class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int i=0;
        int max=0;
        while(i<heights.length){
            if(st.isEmpty() || heights[st.peek()]<=heights[i]) {
                st.push(i++);
            } else {
                int x = st.pop();
                max=Math.max(max,(st.isEmpty()?i:i-st.peek()-1)*heights[x]);
            }
        }
        while(!st.isEmpty()){
            int x = st.pop();
            max=Math.max(max,(st.isEmpty()?i:i-st.peek()-1)*heights[x]);
        }
        return max;
    }
}
