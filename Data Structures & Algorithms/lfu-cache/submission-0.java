class LFUCache {
    class Node {
        int key;
        int val;
        int useCounter;
        Node(int key,int val){
            this.key=key;
            this.val = val;
        }
    }


    Map<Integer,Node> mp;
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
        Node n = mp.get(key);
        update(n);
        return n.val;
    }
    public void update(Node node){
        int oldFreq = node.useCounter;
        node.useCounter=oldFreq+1;
        fmp.get(oldFreq).remove(node.key);
        if(fmp.get(oldFreq).size()==0) fmp.remove(oldFreq);
        if(minFreq==oldFreq && !fmp.containsKey(oldFreq)){
            minFreq=node.useCounter;
        }
        fmp.putIfAbsent(node.useCounter,new HashSet<>());
        fmp.get(node.useCounter).add(node.key);
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
		    Node nd = mp.get(key);
		    nd.val = value;
		    update(nd);
		} else {
            Node n = new Node(key,value);
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