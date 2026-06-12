class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> mp = new TreeMap<Integer,Integer>();
        for(int h:hand){
            mp.put(h,mp.getOrDefault(h,0)+1);
        }
        while(!mp.isEmpty()){
            int key =  mp.firstKey();
            for(int i=1;i<groupSize;i++){
                if(mp.containsKey(key+i)){
                    mp.put(key+i,mp.getOrDefault(key+i,0)-1);
                    if(mp.get(key+i)==0){
                        mp.remove(key+i);
                    }
                } else {
                    return false;
                }
            }
            mp.put(key,mp.getOrDefault(key,0)-1);
            if(mp.get(key)==0){
                mp.remove(key);
            }
        }
        return true;
    }
}
