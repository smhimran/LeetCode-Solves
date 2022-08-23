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
    public boolean isPalindrome(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        ListNode reverse = null;
        
        int len = 1;
        
        while (hare != null && hare.next != null) {
            ListNode temp = new ListNode(tortoise.val, reverse);
            reverse = temp;
            tortoise = tortoise.next;
            
            if (hare.next != null) {
                hare = hare.next.next;
                if (hare != null) {
                    len += 2;
                } else {
                    len++;
                }
            } else {
                hare = hare.next;
            }
        }
        
        if (len % 2 != 0) {
            tortoise = tortoise.next;
        }
        
        boolean palindrome = true;
        
        while (tortoise != null) {
            if (tortoise.val != reverse.val) {
                palindrome = false;
            }
            tortoise = tortoise.next;
            reverse = reverse.next;
        }
        
        return palindrome;
    }
}