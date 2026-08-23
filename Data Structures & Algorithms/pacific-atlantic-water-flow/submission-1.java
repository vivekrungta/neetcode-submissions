class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res= new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] atlantic=new boolean[m][n];
        boolean[][] pacific=new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(i,0,pacific,heights,heights[i][0]);
            dfs(i,n-1,atlantic,heights,heights[i][n-1]);
        }
        for(int i=0;i<n;i++){
            dfs(0,i,pacific,heights,heights[0][i]);
            dfs(m-1,i,atlantic,heights,heights[m-1][i]);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public void dfs(int r,int c,boolean[][] visited,int[][] matrix,int prev){
        if(r<0 || c<0 || r>=matrix.length || c>=matrix[0].length 
           || visited[r][c] || prev>matrix[r][c]) return;
        visited[r][c]=true;
        dfs(r+1,c,visited,matrix,matrix[r][c]);
        dfs(r,c+1,visited,matrix,matrix[r][c]);
        dfs(r-1,c,visited,matrix,matrix[r][c]);
        dfs(r,c-1,visited,matrix,matrix[r][c]);
    }
}
