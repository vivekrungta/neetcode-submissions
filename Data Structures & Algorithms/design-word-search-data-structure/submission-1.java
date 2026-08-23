class WordDictionary {

    class TrieNode {
        TrieNode[] child= new TrieNode[26];
        boolean endWord =false;
    }

    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            if(p.child[word.charAt(i)-'a']==null){
                p.child[word.charAt(i)-'a']=new TrieNode();
            }
            p=p.child[word.charAt(i)-'a'];
        }
        p.endWord=true;
    }

    public boolean search(String word) {
        TrieNode p=root;
        return searchHelp(word,p,0);
    }

    public boolean searchHelp(String word,TrieNode p,int index){
        if(p==null) return false;
        if(index==word.length()) return p.endWord;
        
        if(word.charAt(index)=='.'){
            for(int i=0;i<26;i++){
                if(searchHelp(word,p.child[i],index+1)) return true;
            }
            return false;
        } 
        return searchHelp(word,p.child[word.charAt(index)-'a'],index+1);
        
    }
    
}
