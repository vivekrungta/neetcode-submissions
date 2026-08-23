class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,i,j,word,0)) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board,int i , int j, String word, int index){
        if(index==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        char tmp =board[i][j];
        if(tmp!=word.charAt(index)) return false;
        board[i][j]='*';
        boolean res = false;
        if(helper(board,i-1,j,word,index+1)) res=true;
        else if(helper(board,i+1,j,word,index+1)) res=true;
        else if(helper(board,i,j-1,word,index+1)) res=true;
        else if(helper(board,i,j+1,word,index+1)) res=true;
        board[i][j]=tmp;
        return res;


        
    }
}
