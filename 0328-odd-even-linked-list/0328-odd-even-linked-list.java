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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode oddNow = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenNow = evenHead;
        ListNode now = head;

        int index = 1;

        while (now != null) {
            if (index % 2 == 0) {
                evenNow.next = new ListNode(now.val);
                evenNow = evenNow.next;
            } else {
                oddNow.next = new ListNode(now.val);
                oddNow = oddNow.next;
            }
            now = now.next;
            index++;
        }

        oddNow.next = evenHead.next;
        return oddHead.next;
    }
}