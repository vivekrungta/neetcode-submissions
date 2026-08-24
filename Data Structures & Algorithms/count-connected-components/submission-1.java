class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        for(int edge[]:edges){
            int x = find(edge[0],parent);
            int y = find(edge[1],parent);
            if(x!=y){
                n--;
                parent[x]=y;
            }

        }
        return n;
    }

    private int find(int x,int[] parent){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x],parent);
    }
}
