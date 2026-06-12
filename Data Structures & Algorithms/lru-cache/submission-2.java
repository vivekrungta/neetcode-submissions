class LRUCache {

    class Node {
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key,int val){
            this.key=key;
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int capacity;
    int currSize;
    Map<Integer,Node> mp;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        mp = new HashMap<>();
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node n = mp.get(key);
        remove(n);
        add(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            Node n = mp.get(key);
            n.val = value;
            remove(n);
            add(n);
        } else {
            Node n = new Node(key,value);
            mp.put(key,n);
            add(n);
            if(currSize==capacity) {
                Node t = tail.prev;
                mp.remove(t.key);
                remove(t);
            } else {
                currSize++;
            }
        }
    }
    public void remove(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;

    }
    public void add(Node n){
        n.next = head.next;
        head.next.prev = n;
        n.prev=head;
        head.next =n;
        
    }
}
