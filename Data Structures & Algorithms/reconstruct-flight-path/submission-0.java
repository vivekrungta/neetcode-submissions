class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res= new ArrayList<>();
        Map<String,PriorityQueue<String>> mp = new HashMap<>();
        for(List<String> ticket:tickets){
            PriorityQueue<String> pq= mp.get(ticket.get(0));
            if(pq==null){
                mp.put(ticket.get(0),new PriorityQueue<String>((a,b)->a.compareTo(b)));
            }
            mp.get(ticket.get(0)).add(ticket.get(1));
         }
        Stack<String> st= new Stack<>();
        dfs("JFK",mp,st);
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
    }

    public void dfs(String start,Map<String,PriorityQueue<String>> mp,Stack<String> st) {
        PriorityQueue<String> pq= mp.get(start);
        while(pq!=null && !pq.isEmpty()){
            dfs(pq.poll(),mp,st);
        }
        st.add(start);
    }
}
