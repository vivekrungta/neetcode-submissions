class Solution {
    Set<Integer> antiDiagonalS = new HashSet<>();
    Set<Integer> diagonalS = new HashSet<>();
    Set<Integer> colS = new HashSet<>();
    public int totalNQueens(int n) {
        return helper(0,n);
    }

    public int helper(int row,int size){
        if(row==size) return 1;
        int count =0;
        for(int col=0;col<size;col++){
            if(!colS.contains(col) && !diagonalS.contains(col+row) && !antiDiagonalS.contains(row-col)){
                colS.add(col);
                diagonalS.add(col+row);
                antiDiagonalS.add(row-col);
                count+=helper(row+1,size);
                colS.remove(col);
                diagonalS.remove(col+row);
                antiDiagonalS.remove(row-col);
            }
        }
        return count;
    }

}