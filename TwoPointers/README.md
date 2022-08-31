## 125. Valid Palindrome
Simply use two pointers left(from head) and right(from tail) to loop forward and backward. 2 things to noted:
1. In while loop to update two pointers, we need to set left <= right since this may deal with odd length palindrome case
2. Built-in function--Character.isLetterOrDigigt to exclude other conditions

## 167. Two Sum II - Input Array Is Sorted
Since array has been sorted, we use two pointers from head and tail to track if they can sum up target.
In while loop, we need to set left < right since position cannot be overlapped. If result is found, simply break loop and return. If result is less than target, means greater value needed and move forward left pointer. Same to right pointer

## 11. Container With Most Water
Use two pointer left and right to forward and backward from head and tail, in the meantime update max area answer. Max area should take greater value of minumum height of left and right(bucket effect) multiply the length between left and right

## 42. Trapping Rain Water
Use 2 pointers left and right to track indices. Use 2 variables leftMax and rightMax representing left and right accumulated water and update them on final result.
In while loop to update left and right, we need to judge whether leftMax or rightMax higher. Once one of them is lower, we need to update its side pointers first. Second we need to update side max height with the maximum of its value and updated index position height and add left(right)Max - height[left(right)] to final result
