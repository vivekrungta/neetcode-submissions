class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]> g[] = new List[n+1];
        for(int i=0;i<times.length;i++){
            int src = times[i][0];
            int tgt = times[i][1];
            int time = times[i][2];
            if(g[src]==null) g[src]=new ArrayList<>();
            g[src].add(new int[]{tgt,time});
        }
        int dist[]= new int[n+1];
        Arrays.fill(dist,-1);
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.add(new int[]{0,k});
        while(!q.isEmpty()){
            int[] node = q.poll();
            int src = node[1];
            int d = node[0];
            if(dist[src]!=-1) continue;
            dist[src]=d;
            if(g[src]==null) continue;
            for(int[] child:g[src]){
                int tgt = child[0];
                int time = child[1];
                if(dist[tgt]==-1){
                    q.add(new int[]{time+d,tgt});
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==-1) return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}
