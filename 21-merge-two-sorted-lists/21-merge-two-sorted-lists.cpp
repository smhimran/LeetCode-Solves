/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode *head = new ListNode();
        ListNode *now;
        
        now = head;
        
        while (list1 != nullptr && list2 != nullptr) {
            ListNode* newNode = new ListNode();
            
            if (list1 -> val <= list2 -> val) {
                newNode -> val = list1 -> val;
                list1 = list1 -> next;
            } else {
                newNode -> val = list2 -> val;
                list2 = list2 -> next;
            }
            
            now -> next = newNode;
            
            now = now -> next;
        }
        
        while (list1 != nullptr) {
            ListNode* newNode = new ListNode();
            newNode -> val = list1 -> val;
            list1 = list1 -> next;
            now -> next = newNode;
            now = now -> next;
        }
        
        while (list2 != nullptr) {
            ListNode* newNode = new ListNode();
            newNode -> val = list2 -> val;
            list2 = list2 -> next;
            now -> next = newNode;
            now = now -> next;
        }
        
        return head -> next;
    }
};