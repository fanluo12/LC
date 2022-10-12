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
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return head.val;
        }
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reverse(slow);
        int sum = Integer.MIN_VALUE;
        while (slow != null) {
            sum = Math.max(slow.val + head.val, sum);
            slow = slow.next;
            head = head.next;
        }
        return sum;
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode Next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = Next;
        }
        return pre;
    }
}
