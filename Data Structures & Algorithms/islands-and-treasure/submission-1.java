class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> gates = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) {
                    gates.add(new int[]{i,j});
                } 
            }
            
        }
        int inf = 2147483647;
        int count = 1;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!gates.isEmpty()) {
            int size = gates.size();
            for(int i=0;i<size;i++){
                int[] pop = gates.poll();
                for(int dir[]:dirs){
                    int x= pop[0]+dir[0];
                    int y = pop[1]+dir[1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==inf){
                        grid[x][y]=count;
                        gates.add(new int[]{x,y});
                    }
                }
            }
            count++;
        }
    }
}
