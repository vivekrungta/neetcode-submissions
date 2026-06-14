class Solution {
    public boolean isAlienSorted(String[] words, String order) {
      
      int index[]=new int[26];
      for(int i=0;i<order.length();i++){
        index[order.charAt(i)-'a']=i;
      }
      for(int i=1;i<words.length;i++){
        String parent = words[i-1];
        String curr = words[i];
        int l = Math.min(parent.length(),curr.length());
        int j=0;
        for(;j<l;j++){
            if(index[parent.charAt(j)-'a']>index[curr.charAt(j)-'a']){
                return false;
            }
            if(index[parent.charAt(j)-'a']<index[curr.charAt(j)-'a']){
                break;
            }
        }
        if(j==l && parent.length()>curr.length()) return false;
      }
      return true;
    }
}