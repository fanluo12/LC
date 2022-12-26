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
    public void reorderList(ListNode head) {
        // find middle
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse second half
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode pre = null;
        
        while (secondHalf != null) {
            ListNode tmp = secondHalf.next;
            secondHalf.next = pre;
            pre = secondHalf;
            secondHalf = tmp;
        }
        
        // merge two list
        ListNode first = head, second = pre;
        while (second != null) {
            ListNode tmp1 = first.next, tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
        
    }
}
