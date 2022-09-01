## 206. Reverse Linked List
CLASSIFC WAY TO REVERSE
1. Find length of linked list
2. Declare dummy as 0 node and dummy.next = head. Declare pre = dummy and cur = pre.next
3. For loop through length, each time first find Next node which is cur.next. Then break chain, ie. cur.next = Next.next. Next Next.next = pre.next and pre.next = Next
