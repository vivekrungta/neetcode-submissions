class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        Set<Character> row[]=new HashSet[N];
        Set<Character> col[]=new HashSet[N];
        Set<Character> box[]=new HashSet[N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]=='.') continue;
                if(row[i]!=null && row[i].contains(board[i][j])) return false;
                if(col[j]!=null && col[j].contains(board[i][j])) return false;
                if(box[(i/3)*3+j/3]!=null && box[(i/3)*3+j/3].contains(board[i][j])) return false;
                if(row[i]==null) row[i]=new HashSet<>();
                if(col[j]==null) col[j]=new HashSet<>();
                if(box[(i/3)*3+j/3]==null) box[(i/3)*3+j/3]=new HashSet<>();
                row[i].add(board[i][j]);
                col[j].add(board[i][j]);
                box[(i/3)*3+j/3].add(board[i][j]);
                         
            }
        }
        return true;

    }
}
