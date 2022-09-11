# 9 total - 09/11/2022

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

## 2. Add Two Numbers
Initiate a variable carry which carry the decimal place
while (l1 != null || l2 != null || carry != 0) to loop through. Each time declare a Next node as 0 and assign value to it. The value would be the sum of l1 + l2 + carry if l1 not null else 0 also same to l2. Next connect cur to Next and change carry. After we need to update l1 and l2

## 141. Linked List Cycle
To determine if a linked list has cycle or not, we need to define two pointers, slow and fast where slow moves forward one node speed and fast move two node speed. Once slow meets fast we can know there is cycle

## 23. Merge k Sorted Lists
Create function which can merge two lists
While loop through lists when length not equals to 1. Each time for loop through hall lists and merge 0 and 1, 2 and 3, 4 and 5 so on and so far. If length is odd, then we move remained list to the last, i.e. length / 2 position assigns length - 1 position. Finally we divide list to half

## 25. Reverse Nodes in k-Group
Find length of linked list and use while loop to update length until less than k
In while loop, use classic way to reverse linked list
