class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>(); 
        for(int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->count.get(a)-count.get(b));
        for(int num:count.keySet()){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll();
        }
        return res;
    }
}
