class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i=0;
        int j=0;
        int m= matrix.length-1;
        int n = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        while(i<=m && j<=n){
            for(int curr=j;curr<=n;curr++){
                res.add(matrix[i][curr]);
            }
            i++;
            for(int curr=i;curr<=m;curr++){
                res.add(matrix[curr][n]);
            }
            n--;
            if(j<=n && i<=m){
                for(int curr=n;curr>=j;curr--){
                    res.add(matrix[m][curr]);
                }
                m--;
            }
            if(i<=m && j<=n){
                for(int curr=m;curr>=i;curr--){
                    res.add(matrix[curr][j]);
                }
                j++;
            }
        }
        return res;
    }
}
