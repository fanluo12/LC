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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        // loop through linked list, once elements have descending order, create a new linked list, i.e, use pre to connect them
        while (cur != null) {
            ListNode Next = cur.next;
            // if meet smaller element, pre back to 0 place and connect to smaller element with below
            if (cur.val < pre.val) {
                pre = dummy;
            }
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // note cur.next should connect to previous larger element, which is pre.next
            cur.next = pre.next;
            pre.next = cur;
            cur = Next;
            
        }
        return dummy.next;
    }
}
