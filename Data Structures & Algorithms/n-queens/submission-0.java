class Solution {
    public List<List<String>> solveNQueens(int n) {
        char emptyBoard[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard,res);
        return res;
    }

    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, 
    Set<Integer> cols, char[][] state, List<List<String>> res){
        if(row==state.length){
            res.add(createBoard(state));
            return;
        }
        for (int col = 0; col < state.length; col++) {
            if(cols.contains(col) || diagonals.contains(row-col) || antiDiagonals.contains(row+col) || state[row][col]!='.') continue;
            cols.add(col);
            diagonals.add(row-col);
            antiDiagonals.add(row+col);
            state[row][col]='Q';
            backtrack(row+1, diagonals, antiDiagonals, cols, state,res);
            state[row][col]='.';
            cols.remove(col);
            diagonals.remove(row-col);
            antiDiagonals.remove(row+col);
        }
    }

    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < state.length; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        
        return board;
    }
}
