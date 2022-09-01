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
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        
        int length = 0;
        while (head != null) {
            length += 1;
            head = head.next;
        }
        
        for (int i = 0; i < length - 1; i ++) {
            ListNode Next = cur.next;
            cur.next = Next.next;
            Next.next = pre.next;
            pre.next = Next;
        }
        
        return dummy.next;
        
    }
}
