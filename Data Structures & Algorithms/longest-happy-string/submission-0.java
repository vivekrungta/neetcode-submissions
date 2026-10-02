class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->q[1]-p[1]);
        StringBuilder sb = new StringBuilder();
        if(a!=0) pq.add(new int[]{0,a});
        if(b!=0) pq.add(new int[]{1,b});
        if(c!=0) pq.add(new int[]{2,c});
        while(pq.size()>0){
            int[] tmp = pq.poll();
            char tc = (char)(tmp[0]+'a');
            if(sb.length()>=2 && sb.charAt(sb.length()-1)==tc && sb.charAt(sb.length()-2)==tc) {
                if(pq.isEmpty()) continue;
                int[] tmp2 = pq.poll();
                sb.append((char)(tmp2[0]+'a'));
                if (tmp2[1]>1) {
                    tmp2[1]-=1;
                    pq.add(tmp2);                  
                }
            } else {
                tmp[1]-=1;
                sb.append(tc);
            }
            if(tmp[1]!=0){
                pq.add(tmp);
            }
        }
        
        return sb.toString();
    }
}