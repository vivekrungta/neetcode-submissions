class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean flag = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,q);
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }
        int step=0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] point = q.poll();
                for(int[] dir:dirs){
                    int x=dir[0]+point[0];
                    int y=dir[1]+point[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length){
                        if(grid[x][y]==1) return step;
                        if(grid[x][y]==2) continue;
                        if(grid[x][y]==0) {
                            q.add(new int[]{x,y});
                            grid[x][y]=2;
                        } 
                    }
                }
            }
            step++;
        }
        return step;
    }

    public void dfs(int[][] A,int i,int j,Queue<int[]> q){
        if(i<0 || i>=A.length || j<0 || j>=A[0].length || A[i][j]!=1) return;
        q.add(new int[]{i,j});
        A[i][j]=2;
        dfs(A,i-1,j,q);
        dfs(A,i+1,j,q);
        dfs(A,i,j-1,q);
        dfs(A,i,j+1,q);
    }
}