class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int val = asteroids[i];
            if(val<0){
                val=-val;
                while(!st.isEmpty() && st.peek()>0 && st.peek()<val) st.pop();
                if(st.isEmpty() || st.peek()<0) st.push(-val);
                else if(!st.isEmpty() && st.peek()==val) st.pop();
                
            } else {
                st.push(val);
            }
        }
        int[] res =new int[st.size()];
        int i=0;
        for(Integer s:st) res[i++]=s;
        return res;

    }
}