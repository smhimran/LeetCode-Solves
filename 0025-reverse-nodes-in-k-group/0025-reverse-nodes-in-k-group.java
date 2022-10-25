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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode now = head;
        ListNode temp, prev = null;
        
        int len = 0;
        
        while (now != null) {
            len++;
            now = now.next;
        }
        
        if (len < k)
            return head;
        
        now = head;
        int count = 0;
        
        while (count < k) {
            temp = now.next;
            now.next = prev;
            prev = now;
            now = temp;
            count++;
        }
        
        head.next = reverseKGroup(now, k);
        
        return prev;
    }
}