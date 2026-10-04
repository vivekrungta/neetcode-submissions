class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] box = new int[m][n];
        if(obstacleGrid[0][0]==1) return 0;
        box[0][0]=1;
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                box[i][0]=box[i-1][0];
            }   
        }
        for(int j=1;j<n;j++){
             if(obstacleGrid[0][j]!=1){
                box[0][j]=box[0][j-1];
             }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1){
                    box[i][j]=box[i][j-1]+box[i-1][j];
                }
                
            }
        
        }
        return box[m-1][n-1];
    }
}