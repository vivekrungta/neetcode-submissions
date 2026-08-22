/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode sec= slow.next;
        slow.next=null;
        merge(head,reverse(sec));
    }
    public void merge(ListNode a,ListNode b) {
        while(b!=null){
            ListNode tmp =a.next;
            a.next=b;
            a=tmp;
            tmp = b.next;
            b.next=a;
            b=tmp;
        }
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
