class MyCircularQueue {

    class Node {
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val=val;
        }
    }
    int size;
    Node head;
    Node tail;
    int count=0;
    public MyCircularQueue(int k) {
        head=new Node(-1);
        tail = new Node(-1);
        head.next=tail;
        tail.prev=head;
        size=k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        Node node = new Node(value);
        tail.prev.next=node;
        node.prev=tail.prev;
        tail.prev=node;
        node.next=tail;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        head.next.next.prev=head;
        head.next=head.next.next;
        count--;
        return true;
    }
    
    public int Front() {
        return head.next.val;
    }
    
    public int Rear() {
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return head.next==tail;
    }
    
    public boolean isFull() {
        return count==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */