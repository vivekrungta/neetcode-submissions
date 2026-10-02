class Solution {
    public String reorganizeString(String S) {
        int count[]=new int[26];
        int len = S.length();
        for(int i=0;i<len;i++){
            count[S.charAt(i)-'a']++;
            if(count[S.charAt(i)-'a']>(len+1)/2) return "";
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<26;i++){
            if(count[i]!=0)
                pq.add(new int[]{i,count[i]});
        }
        StringBuilder sb= new StringBuilder();
        while(pq.size()>=2){
            int[] first = pq.poll();
            int[] second=pq.poll();
            sb.append((char)(first[0]+'a'));
            sb.append((char)(second[0]+'a'));
            if(--first[1]!=0)  pq.add(first);
            if(--second[1]!=0) pq.add(second);
        }
        if (pq.size() > 0) sb.append((char)(pq.poll()[0]+'a'));
        return sb.toString();
    }
}