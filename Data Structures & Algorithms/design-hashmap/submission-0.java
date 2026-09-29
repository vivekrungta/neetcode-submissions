class MyHashMap {

    private static class ListNode {
        ListNode next;
        int key;
        int value;
        ListNode(int key,int value){
            this.key=key;
            this.value = value;
        }
    }
    ListNode[] mp;

    public MyHashMap() {
        mp=new ListNode[10000];
        for(int i=0;i<mp.length;i++){
            mp[i]=new ListNode(0,0);
        }
    }
    
    public void put(int key, int value) {
        ListNode curr = mp[key % mp.length];
        while(curr.next!=null){
            if(curr.next.key==key){
                curr.next.value = value;
                return;
            }
            curr=curr.next;
        }
        curr.next=new ListNode(key,value);
    }
    
    public int get(int key) {
        ListNode curr = mp[key % mp.length];
        while (curr.next != null) {
            if (curr.next.key == key) {
                return curr.next.value;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        ListNode curr = mp[key % mp.length];
        while(curr.next!=null){
            if(curr.next.key==key){
                curr.next=curr.next.next;
                return;
            }
            curr=curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */