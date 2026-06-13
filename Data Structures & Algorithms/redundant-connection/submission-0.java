class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        int[] parent = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        for(int edge[]:edges){
            int x = find(edge[0],parent);
            int y = find(edge[1],parent);
            if(x!=y){
                parent[x]=y;
            } else {
                return edge;
            }

        }
        return new int[0];
    }

    private int find(int x,int[] parent){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x],parent);
    }
}
