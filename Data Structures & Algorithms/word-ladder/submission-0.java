class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> memo = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int len=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                char[] word=q.poll().toCharArray();
                for(int j=0;j<word.length;j++){
                    char tmp=word[j];
                    for(char c='a';c<='z';c++) {
                        word[j]=c;
                        String chk = String.valueOf(word);
                        if(memo.contains(chk)) {
                            if(endWord.equals(chk)) return len+1;
                            q.add(chk);
                            memo.remove(chk);
                        }
                    }
                    word[j]=tmp;
                }

            }
            len++;
        }
        return 0;
    }
}
