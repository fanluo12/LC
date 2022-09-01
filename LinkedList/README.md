## 206. Reverse Linked List
CLASSIFC WAY TO REVERSE
1. Find length of linked list
2. Declare dummy as 0 node and dummy.next = head. Declare pre = dummy and cur = pre.next
3. For loop through length, each time first find Next node which is cur.next. Then break chain, ie. cur.next = Next.next. Next Next.next = pre.next and pre.next = Next

## 21. Merge Two Sorted Lists
while (list1 != null && list2 != null) to loop through and compare node.val to add to new linked list. Note this while loop satisfy both two exists. Once one list loops over and need to judge if the other is null or not. If not null add rest of remained list to new linked list

## 19. Remove Nth Node From End of List
First use a fast pointer forward n times.
Second sent slow pointer(from begining) and fast pointer forward together until fast is null.
Then jump slow pointer to the node after its next node

## 138. Copy List with Random Pointer
Use hash map to put node into when looping through linked list.
Next looping through again linked list, and map.get(current node).next(random) = map.get(curent node.next(random))
Return map.get(head)
