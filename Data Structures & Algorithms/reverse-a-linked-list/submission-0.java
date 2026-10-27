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
    public ListNode reverseList(ListNode head) {
        // logic; point cur to prev
        // then update cur and prev
        // using temp variable for cur.next

        ListNode prev = null; // head has nothing that pionts to it
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next; // next node
            curr.next = prev; // point curr to prev
            prev = curr; // update prev
            curr = temp; // update curr
        }

        return prev;
    }
}
