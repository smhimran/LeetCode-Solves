/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return solution(headA, headB);
    }
    
    // Updated solution. Time: O(n + m), Memory: O(!)
    private ListNode solution(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            
            a = a.next;
            b = b.next;
            
            if (a == null) {
                a = headB;
            } else if (b == null) {
                b = headA;
            }
        }
        
        return null;
    }    
    
    // This is the solution I first came up with. Time: O(2n + 2m), Memory O(1)
    private ListNode firstSolution(ListNode headA, ListNode headB) {
        // Buffer means how many nodes this list is behind than the other
        int bufferA = 0, bufferB = 0;
        ListNode a = headA;
        ListNode b = headB;
        
        while (a.next != null && b.next != null) {
            a = a.next;
            b = b.next;
        }
        
        
        while (a.next != null) {
            bufferA++;
            a = a.next;
        }
        
        while (b.next != null) {
            bufferB++;
            b = b.next;
        }
        
        a = headA;
        b = headB;
        
        while (bufferA != 0) {
            a = a.next;
            bufferA--;
        }
        
        while (bufferB != 0) {
            b = b.next;
            bufferB--;
        }
        
        ListNode ret = null;
        
        while (a != null && b != null) {
            if (a == b) {
                ret = a;
                break;
            }
            
            a = a.next;
            b = b.next;
        }
        
        return ret;
    }
}