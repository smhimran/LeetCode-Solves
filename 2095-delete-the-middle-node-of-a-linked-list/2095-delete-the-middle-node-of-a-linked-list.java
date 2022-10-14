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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        
        ListNode hare = head;
        ListNode tortoise = head;

        while (hare.next.next != null && hare.next.next.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        tortoise.next = tortoise.next.next;

        return head;
    }
}