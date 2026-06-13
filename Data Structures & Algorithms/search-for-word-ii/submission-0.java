class Solution {

    class TrieNode {
        TrieNode[] child= new TrieNode[26];
        boolean endWord =false;
    }

    TrieNode root;
    

    public void insert(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            if(p.child[word.charAt(i)-'a']==null){
                p.child[word.charAt(i)-'a']=new TrieNode();
            }
            p=p.child[word.charAt(i)-'a'];
        }
        p.endWord=true;
    }

    
    public List<String> findWords(char[][] board, String[] words) {
        root=new TrieNode();
        for(String word:words){
            insert(word);
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                helper(board,i,j,new StringBuilder(),root,res);
            }
        }
        return res;
    }


    public void helper(char[][] board,int i,int j,StringBuilder sb,TrieNode p,List<String> res){
        if(i>=board.length|| i<0 || j<0 || j>=board[0].length) return;
        char tmp = board[i][j];
        if(tmp=='*' || p.child[board[i][j]-'a']==null) return;
        int len = sb.length();
        sb.append(tmp);
        board[i][j]='*';
        p=p.child[tmp-'a'];
        if(p.endWord) {
            res.add(sb.toString());
            p.endWord=false;
        }
        helper(board,i+1,j,sb,p,res);
        helper(board,i-1,j,sb,p,res);
        helper(board,i,j-1,sb,p,res);
        helper(board,i,j+1,sb,p,res);
        sb.setLength(len);
        board[i][j]=tmp;
    }


    

    
}
