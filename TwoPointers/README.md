# 11 total - 09/11/2022

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

## 15. 3Sum
Since we need to exclude duplicate answer and there may be multiple answers, we need to for loop through every index of array leaving last two indices(since we need 3 sum), from each index i, we need to define left and right pointers from its next position and last position under circumstance that i position is not same as i - 1 position or i is 0. After we set left(i + 1) and right(last index) based on i position, we can assume target is -nums[i] and we need to update left and right to find target. In while loop of updating left and right pointers, we still need to add extra steps to judge if left and right pointer position's values same as left + 1 or right - 1 since we need no duplicate answer

## 9. Palindrome Number
Although this is a number rather data structure, we can still use pointers idea
First negative value would never be a palindrome number
left = 0 and right = number. while (right > 0), each time we update left = left * 10 + right % 10 and right / 10 to see finally they equal or not.

## 26. Remove Duplicates from Sorted Array && 27. Remove Element && 80. Remove Duplicates from Sorted Array II
These two are similar
For 26,
Use left pointer(starts at 0 index) and right pointer(starts at 1 index) and while loop through right index until length
While looping right index, if left index number is same as right index, right ++ until non-duplicate plcae. Then update left and switch with right position. Note we need to add a judgement to see if right out of bounds
For 27, 
Use left pointer and right pointer all starts at 0 since nums length could be 0 and 1.
While loop right until length, if right position is not val, switch left and right and update left++
For 80,
Use left = 0 and right = 0 as poiner. While loop through right pointer. If left < 2 or left - 2 element != right, swap left and right and update left

## 28. Find the Index of the First Occurrence in a String
For loop through string, for each index initiate main string pointer and substring pointer. While main string[pointer1] == substring[pointer2] we update two pointers and check if substring pointer reaches end
