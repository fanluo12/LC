
## 103. Binary Tree Zigzag Level Order Traversal
Use two stack to store. First stack pop element, and push its right and left to stack1. Then pop stack2, push element's left and right to stack1

## 107. Binary Tree Level Order Traversal II
Same as level order traversal, only addFirst for each level

## 958. Check Completeness of a Binary Tree
Level order traversal each level, once meet null node, we mark seenEmpty(boolean variable) as true and break single loop. Once we meet a non-node and seenEmpty is true, means after null node there is other node, we return false
