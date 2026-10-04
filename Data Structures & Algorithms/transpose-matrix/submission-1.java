class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == n)
        {
            for(int r =0;r<m;r++)
            {
                for(int c = 0;c<r;c++)
                {
                    int tmp = matrix[r][c];
                    matrix[r][c] = matrix[c][r];
                    matrix[c][r] = tmp;
                }
            }
            return matrix;
        }
        int[][] res=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j][i]=matrix[i][j];
            }
        }
        return res;
    }
}