class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) {
            return Arrays.asList(0);
        }
        List<Integer> g[] = new List[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(g[i].size()==1){
                leaves.add(i);
            }
        }
        while(n>2){
            n=n-leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer leave:leaves) {
                int d = g[leave].get(0);
                g[d].remove(leave);
                    if(g[d].size()==1){
                        newLeaves.add(d);
                    }
            }
            leaves=newLeaves;
        }
        return leaves;
    }
}