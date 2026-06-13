class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        
        int[][] cache = new int[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(longestIncreasingPathHelper(matrix,cache,i,j,Integer.MIN_VALUE),max);
            }
        }
        
        return max;
    }
    public int longestIncreasingPathHelper(int[][] matrix,int[][] cache,int i,
                                           int j,int prev) {
        if(i<0 || j< 0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]<=prev) { 
            return 0;
        }
        if(cache[i][j]!=0) return cache[i][j];
        
        int s1=longestIncreasingPathHelper(matrix,cache,i+1,j,matrix[i][j]);
        int s2=longestIncreasingPathHelper(matrix,cache,i-1,j,matrix[i][j]);
        int s3=longestIncreasingPathHelper(matrix,cache,i,j-1,matrix[i][j]);
        int s4=longestIncreasingPathHelper(matrix,cache,i,j+1,matrix[i][j]);
        
        cache[i][j]=Math.max(Math.max(s1,s2),Math.max(s3,s4))+1;
        return cache[i][j];
    }
    
}
