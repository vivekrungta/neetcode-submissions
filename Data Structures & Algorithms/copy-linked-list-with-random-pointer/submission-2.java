/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr = head ; 
        while(curr!=null){
            Node tmp = new Node(curr.val);
            tmp.next=curr.next;
            curr.next=tmp;
            curr=tmp.next;
        }
        curr=head;

        while(curr!=null){
            if(curr.random!=null)
                curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        Node copyHead=head.next;
        Node copy=copyHead;
        curr=head;
        while(curr!=null){
            curr.next=curr.next.next;
            if(copy.next!=null)
                copy.next=copy.next.next;
            curr=curr.next;
            copy=copy.next;
        }

        return copyHead;


    }
}
