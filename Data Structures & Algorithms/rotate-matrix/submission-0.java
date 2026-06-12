class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            reverse(matrix[i]);
        }
    }

    public void reverse(int[] a){
        int l =0;
        int h = a.length-1;
        while(l<h){
            int tmp = a[l];
            a[l]=a[h];
            a[h]=tmp;
            l++;
            h--;
        }
    }
}
