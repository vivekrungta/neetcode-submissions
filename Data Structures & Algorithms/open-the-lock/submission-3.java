class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> st = new HashSet<>();
        st.addAll(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        if(st.contains("0000") || st.contains(target)) return -1;
        q.add("0000");
        int count=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String last = q.poll();
                if(last.equals(target)) return count;
                for(int j=0;j<4;j++){
                    int val = last.charAt(j) - '0';         
                    int inc = val==9 ? 0: val+1;
                    int dec = val==0 ? 9: val-1;
                    String next = last.substring(0,j)+(char)(inc+'0')+last.substring(j+1);
                    String prev = last.substring(0,j)+(char)(dec+'0')+last.substring(j+1);
                    if(!st.contains(next)){
                        st.add(next);
                        q.add(next);
                    }
                    if(!st.contains(prev)){
                        st.add(prev);
                        q.add(prev);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}