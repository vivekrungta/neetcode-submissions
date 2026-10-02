class LFUCache {
    class Data {
        int val;
        int useCounter;
        Data(int val){
            this.val = val;
        }
    }


    Map<Integer,Data> mp;
    Map<Integer,Set<Integer>> fmp;
    int minFreq; 
    int capacity;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        mp=new HashMap<>();
        fmp=new HashMap<>();
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Data n = mp.get(key);
        update(n,key);
        return n.val;
    }
    public void update(Data node,int key){
        int oldFreq = node.useCounter;
        node.useCounter=oldFreq+1;
        fmp.get(oldFreq).remove(key);
        if(fmp.get(oldFreq).size()==0) fmp.remove(oldFreq);
        if(minFreq==oldFreq && !fmp.containsKey(oldFreq)){
            minFreq=node.useCounter;
        }
        fmp.putIfAbsent(node.useCounter,new HashSet<>());
        fmp.get(node.useCounter).add(key);
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
		    Data nd = mp.get(key);
		    nd.val = value;
		    update(nd,key);
		} else {
            Data n = new Data(value);
            n.useCounter=1;
            if(capacity==mp.size()){
                int fst = fmp.get(minFreq).iterator().next();
		        mp.remove(fst);
		        fmp.get(minFreq).remove(fst);
            } 
            mp.put(key,n);
    		fmp.putIfAbsent(1,new LinkedHashSet<>());
    		fmp.get(1).add(key);
    		minFreq=1;
                
            
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */