# 7 total - 09/11/2022

## 704. Binary Search && 35. Search Insert Position
### 704
Simply while (left <= right) and find mid of left and right pointer
### 35
while (left <= right) -> if (nums[mid] >= target), right = mid + 1, else left = mid - 1. Return left

## 74. Search a 2D Matrix
User row = 0 and col = columns - 1 variable to update. If matrix[row][col] < target, update row +1. If matrix[row][col] > target, update col -1. Note that need to satisfy row <= ROWS && col >= 0

## 875. Koko Eating Bananas
Find maximum pile which is the max speed of koko eating(variable as right)
Set minimum eating speed as left = 1, so we need to search between right and left speed with binary search to find a minumum speed which could eat all bananas in given hour
Use while loop to binary search, assume middle eating speed is k, and we update the total hour of earing all piles with for loop through piles. This hour variable only records ceiling of each pile / k, i.e. less than one integer we need to count as this integer. It could also be converted to (pile + k - 1)/k
Once hour been updated through piles, compare with final hour to adjust left or right pointer

## 33. Search in Rotated Sorted Array
Use left and right pointer to binary search. If nums[mid] < nums[right], if the element between middle and right happens to be ascending order, update left pointer, else right pointer. Also, if nums[mid] > nums[right], if the element from left to middle happens to be ascending order, update right pointer else left pointer

## 153. Find Minimum in Rotated Sorted Array
Use left and right pointer to binary search.
In while loop(left <= right), if left position already less than right, which means left is what we looking for and simply return it. Then we find middle index of left and right. Note there are few situations:
1. [2, 1], mid is 0. nums[mid] should >= nums[left] and then update left to mid + 1
2. [3, 1, 2], mid is less than right. In this time right should be mid

## 34. Find First and Last Position of Element in Sorted Array
This is one main different from binary search. When we find nums[mid] == target, we need to update to both direction to find left most and right most indices.
After we find nums[mid] == target, we assign left and right pointer as mid and use while loop to update them

## 69. Sqrt(x)
Use binary search to find square root. Left as 1 and right as x. Each time we find mid, we judge if mid^2 <= x and (mid + 1)^2 > x and return
