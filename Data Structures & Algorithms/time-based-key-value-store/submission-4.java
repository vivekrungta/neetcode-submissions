class TimeMap {

    Map<String,TreeMap<Integer,String>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key,new TreeMap<>());
        mp.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(mp.containsKey(key)) {
            TreeMap<Integer,String> tmp = mp.get(key);
            Integer tkey = tmp.floorKey(timestamp);
            return tkey==null?"":tmp.get(tkey);
        }
        return "";
    }
}
