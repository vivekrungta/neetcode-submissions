class FreqStack {
    Map<Integer,List<Integer>> fmp;
    Map<Integer,Integer> cmp;
    int maxF=0;
    public FreqStack() {
        fmp = new HashMap<>();
        cmp = new HashMap<>();
    }
    
    public void push(int val) {
        int frequency = cmp.getOrDefault(val, 0)+1;
        cmp.put(val,frequency);
        fmp.putIfAbsent(frequency,new ArrayList<>());
        fmp.get(frequency).add(val);
        maxF=Math.max(maxF,frequency);
    }
    
    public int pop() {
        List<Integer> group = fmp.get(maxF);
        int val = group.remove(group.size() - 1);

        cmp.put(val, cmp.get(val) - 1);

        if (group.isEmpty()) {
            fmp.remove(maxF);
            maxF--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */