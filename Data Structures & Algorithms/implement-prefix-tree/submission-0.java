class PrefixTree {
    class TrieNode {
        TrieNode[] child= new TrieNode[26];
        boolean endWord =false;
    }

    TrieNode root;
    public PrefixTree() {
         root=new TrieNode();
    }

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

    public boolean search(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            if(p.child[word.charAt(i)-'a']==null){
                return false;
            }
            p=p.child[word.charAt(i)-'a'];
        }
        return p.endWord==true;
    }

    public boolean startsWith(String prefix) {
        TrieNode p=root;
        for(int i=0;i<prefix.length();i++){
            if(p.child[prefix.charAt(i)-'a']==null){
                return false;
            }
            p=p.child[prefix.charAt(i)-'a'];
        }
        return true;
    }
}
