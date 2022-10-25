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
public class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode node1 = l1, node2 = l2, sumNode = null, prevNode = null, firstNode = null;
        
        int carry = 0, sum = 0;
        
        while (node1 != null && node2 != null) {
            int now = node1.val + node2.val + carry;
            
            sum = now % 10;
            
            carry = now / 10;
            
            sumNode = new ListNode(sum, null);
            
            if (prevNode != null) {
                prevNode.next = sumNode;
            }
            
            if (firstNode == null) {
                firstNode = sumNode;
            }
            
            prevNode = sumNode;
            
            node1 = node1.next;
            node2 = node2.next;
        }
        
        while (node1 != null) {
            int now = node1.val + carry;
            
            sum = now % 10;
            
            carry = now / 10;
            
            sumNode = new ListNode(sum, null);
            
            if (prevNode != null) {
                prevNode.next = sumNode;
            }
            
            prevNode = sumNode;
            
            node1 = node1.next;
        }
        
        while (node2 != null) {
            int now = node2.val + carry;
            
            sum = now % 10;
            
            carry = now / 10;
            
            sumNode = new ListNode(sum, null);
            
            if (prevNode != null) {
                prevNode.next = sumNode;
            }
            
            prevNode = sumNode;
            
            node2 = node2.next;
        }
        
        if (carry != 0) {
            sumNode = new ListNode(carry, null);
            prevNode.next = sumNode;            
        }
        
        
        return firstNode;
    }
}