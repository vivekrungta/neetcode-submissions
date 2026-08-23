class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        for(int edge[]:edges){
            int x = find(edge[0],parent);
            int y = find(edge[1],parent);
            if(x!=y){
                parent[x]=y;
            } else {
                return false;
            }

        }
        return n-1==edges.length;
    }

    

    private int find(int x,int[] parent){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x],parent);
    }
    
}
