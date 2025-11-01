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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Skip all head nodes that should be removed
        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}

// Time: O(n + m)
// Space: O(m)

// class Solution {
//     public ListNode modifiedList(int[] nums, ListNode head) {
//         for (int ele : nums) {
//             head = delete(head, ele);
//         }
//         return head;
//     }

//     private ListNode delete(ListNode head, int ele) {
//         if (head == null) {
//             return null;
//         }
//         // delete all possible starting positions
//         while (head.val == ele) {
//             head = head.next;
//         }
//         ListNode temp = head;
//         while (temp.next != null) {
//             if (temp.next.val == ele) {
//                 temp.next = temp.next.next;
//             } else {
//                 temp = temp.next;
//             }
//         }
//         return head;
//     }
// }