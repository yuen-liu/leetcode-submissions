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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // recursive method: O(n + m runtime) but spacetime O(n + m)
        // iterative method: same runtime but only O(1) spacetime

        ListNode dummy = new ListNode(0);
        ListNode node = dummy; // references same object
        
        while (list1 != null && list2 != null) {
            // check if list1 is less than list2
            if (list1.val < list2.val) {
                // we put list1 and update list1
                node.next = list1;
                list1 = list1.next;
            } else {
                // we put list2 and update list2
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1; // put in remaining list1
        } else {
            node.next = list2; // otherwise put in remaining list2
        }

        return dummy.next;
    }
}