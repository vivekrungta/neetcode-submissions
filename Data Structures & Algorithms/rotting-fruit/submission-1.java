class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int rotten = 0;
        int fresh = 0;
        int total =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    rotten++;
                    total++;
                } else if (grid[i][j]==1){
                    fresh++;
                    total++;
                }
                
            }
        }
        if(fresh==0) return 0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int res=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] rotOr = q.poll();
                for(int dir[]:dirs){
                    int x = rotOr[0]+dir[0];
                    int y = rotOr[1]+dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        q.add(new int[]{x,y});
                        rotten++;
                    }
                }
            }
            res++;
        }
        return rotten==total?res-1:-1;
    }
}
