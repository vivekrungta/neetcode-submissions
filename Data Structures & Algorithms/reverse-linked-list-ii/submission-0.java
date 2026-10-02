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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        
        ListNode curr = dummy;
        while(left!=1){
            left--;
            right--;
            curr=curr.next;
        }
        ListNode mem = curr;
        curr = curr.next;
        ListNode prev=null;

        while(right!=0){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            right--;
        }
        mem.next.next=curr;
        mem.next=prev;
        
        return dummy.next;
    }
}