class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int m = matrix.length;
        int n = matrix[0].length;
        int h = m*n-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(target==matrix[mid/n][mid%n]) return true;
            if (target<matrix[mid/n][mid%n]){
                h=mid-1;
            } else {
                l=mid+1;
            }
        }
        return false;
    }
}
