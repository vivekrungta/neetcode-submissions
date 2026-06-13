class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> mp = new HashMap<>();
      for(String word:words){
        for(int i=0;i<word.length();i++){
            mp.putIfAbsent(word.charAt(i),new ArrayList<>());
        }
      }
      int indegree[] = new int[26];
      for(int i=1;i<words.length;i++){
        String parent = words[i-1];
        String curr = words[i];
        int l = Math.min(parent.length(),curr.length());
        int j=0;
        for(;j<l;j++){
            if(parent.charAt(j)!=curr.charAt(j)){
                mp.get(parent.charAt(j)).add(curr.charAt(j));
                indegree[curr.charAt(j)-'a']++;
                break;
            }
        }
        if(j==l && parent.length()>curr.length()) return "";
      }
        Queue<Character> q = new LinkedList<>();
        for(char c:mp.keySet()){
            if(indegree[c-'a']==0) q.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            sb.append(c);
            for(char ch:mp.get(c)){
                indegree[ch-'a']--;
                if(indegree[ch-'a']==0) q.add(ch);
            }
        }
        return sb.length()==mp.size()?sb.toString():"";
      
    }
}
