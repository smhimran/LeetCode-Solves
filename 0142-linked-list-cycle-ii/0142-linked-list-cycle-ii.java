/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode tortoise2 = head;
        ListNode hare = head;
        ListNode ret = null;
        
        boolean cycle = false;
        
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            
            if (hare == tortoise) {
                cycle = true;
                break;
            }
        }
        
        if (cycle) {
            while (tortoise != tortoise2) {
                tortoise = tortoise.next;
                tortoise2 = tortoise2.next;
            }
            
            ret = tortoise;
        }
        
        return ret;
    }
}