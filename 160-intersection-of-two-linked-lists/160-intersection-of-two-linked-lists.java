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
        
        if (headA == null || headB == null) return null;
        
        int alen = getLength(headA);
        int blen = getLength(headB);
        
        ListNode currA = headA, currB = headB;
        if (alen > blen) {
            for (int i = 0; i < alen - blen; i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < blen - alen; i++) {
                currB = currB.next;
            }
        }
        
        while (currA != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
    
    // Get the length of a linked list;
    private int getLength(ListNode head) {
        if (head == null) return 0;
        
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        
        return len;
    }
}