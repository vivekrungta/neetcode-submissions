class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String str:strs){
            int count[] = new int[26];
            for(int i=0;i<str.length();i++){
                count[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                if(count[i]!=0){
                    sb.append((char)i+'a').append(count[i]);
                }
            }
            mp.putIfAbsent(sb.toString(),new ArrayList<>());
            mp.get(sb.toString()).add(str);

        }
        return new ArrayList<>(mp.values());
    }
}
