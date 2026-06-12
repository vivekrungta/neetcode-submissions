class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> conn = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i!=j){
                    conn.add(new int[]{i,j,dist(points,i,j)});
                }
            }
        }
        Collections.sort(conn,(a,b)->a[2]-b[2]);
        int[] parents = new int[points.length];
        for(int i=0;i<parents.length;i++) parents[i]=i;
        int cost=0;
        int count=0;
        for(int[] edge:conn){
            int x = find(parents,edge[0]);
            int y = find(parents,edge[1]);
            if(x!=y){
                parents[x]=y;
                count++;
                cost+=edge[2];
                if(count==points.length-1){
                    return cost;
                }
            }
        }
        return 0;

    }

    public int find(int parents[],int i){
        if(parents[i]==i) return i;
        return parents[i]=find(parents,parents[i]);
    }

    public int dist(int[][] points,int i,int j){
        return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
    }
}
