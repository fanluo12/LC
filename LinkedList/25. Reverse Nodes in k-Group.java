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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        
        while (length >= k) {
            for (int i = 0; i < k - 1; i ++) {
                ListNode Next = cur.next;
                cur.next = Next.next;
                Next.next = pre.next;
                pre.next = Next;
            }
            pre = cur;
            cur = cur.next;
            length -= k;
        }
        return dummy.next;
    }
}
