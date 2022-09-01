## 206. Reverse Linked List
CLASSIFC WAY TO REVERSE
1. Find length of linked list
2. Declare dummy as 0 node and dummy.next = head. Declare pre = dummy and cur = pre.next
3. For loop through length, each time first find Next node which is cur.next. Then break chain, ie. cur.next = Next.next. Next Next.next = pre.next and pre.next = Next

## 21. Merge Two Sorted Lists
while (list1 != null && list2 != null) to loop through and compare node.val to add to new linked list. Note this while loop satisfy both two exists. Once one list loops over and need to judge if the other is null or not. If not null add rest of remained list to new linked list
