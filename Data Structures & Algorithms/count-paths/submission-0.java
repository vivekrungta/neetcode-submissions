class Solution {
    public int uniquePaths(int m, int n) {
        int[][] box = new int[m][n];
        box[0][0]=1;
        for(int i=1;i<m;i++){
            box[i][0]=box[i-1][0];
        }
        for(int j=1;j<n;j++){
            box[0][j]=box[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                box[i][j]=box[i][j-1]+box[i-1][j];
            }
        
        }
        return box[m-1][n-1];
    }
}
