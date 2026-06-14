class Solution {
    public int numSquares(int n) {
        Set<Integer> st = new HashSet<>();
        for(int i=1;i*i<=n;i++) st.add(i*i);
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int len=0;
        boolean[] visited = new boolean[n+1];
        visited[n]=true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int a = q.poll();
                if(a==0) return len;
                for(int s:st){
                    if(a>=s && !visited[a-s]){
                        visited[a-s]=true;
                        q.add(a-s);
                    }
                }
            }
            len++;
        }
        return -1;

    }
}