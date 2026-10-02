class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> mp = new TreeMap<>();
        for(int i=0;i<trips.length;i++){
            mp.put(trips[i][1],mp.getOrDefault(trips[i][1], 0)+trips[i][0]);
            mp.put(trips[i][2],mp.getOrDefault(trips[i][2], 0)-trips[i][0]);
        }
        int count=0;
        for(int key:mp.keySet()){
            count+=mp.get(key);
            if(count>capacity) return false;
        }
        return true;
    }
}