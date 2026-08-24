class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1){
                    if(board[i][j]=='O'){
                        SolveHelper(board,i,j);
                    }
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='1')
                    board[i][j]='O';
                else 
                    board[i][j]='X';
            }
        }
    }

        public void SolveHelper(char[][] board,int r,int c) {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length) return;
        if(board[r][c]=='X' || board[r][c]=='1') return;
        board[r][c]='1';
        SolveHelper(board,r-1,c);
        SolveHelper(board,r+1,c);
        SolveHelper(board,r,c-1);
        SolveHelper(board,r,c+1);
        
    }
}
