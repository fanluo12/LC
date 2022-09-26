# 13 total - 09/18/2022

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

## 153. Find Minimum in Rotated Sorted Array && 81. Search in Rotated Sorted Array II && 154. Find Minimum in Rotated Sorted Array II
### 153
Use left and right pointer to binary search.
In while loop(left <= right), if left position already less than right, which means left is what we looking for and simply return it. Then we find middle index of left and right. Note there are few situations:
1. [2, 1], mid is 0. nums[mid] should >= nums[left] and then update left to mid + 1
2. [3, 1, 2], mid is less than right. In this time right should be mid
### 81
Same as 153 and just return boolean value. Use left and right pointer to find middle pointer. In while(left <= right) loop, if we find middle pointer is target, then simply return true. If left < mid, we need to judge target belong to [left, mid] or not. Same as left > mid
### HARD**154
1. while left < right
2. if mid < right -- right = mid; else if mid > right -- left = mid + 1; else right--

## 34. Find First and Last Position of Element in Sorted Array
This is one main different from binary search. When we find nums[mid] == target, we need to update to both direction to find left most and right most indices.
After we find nums[mid] == target, we assign left and right pointer as mid and use while loop to update them

## 69. Sqrt(x)
Use binary search to find square root. Left as 1 and right as x. Each time we find mid, we judge if mid^2 <= x and (mid + 1)^2 > x and return

## 367. Valid Perfect Square
First remember cannot use mid * mid since stack overflow. So method1 we can use long to represent.
For method2, to avoid stack overflow, we need to replace mid * mid with tmp = num / mid and compare tmp and mid to see if they equal or not. But remember, int tmp can be fake since 5 /2 = 2, so we need to add remainder to judge together

## ** 410. Split Array Largest Sum
We use two extreme situations to perform binary search. The largest sum is the sum of all elements which no cut and smallest sum(although comparing to largest solution, it is the largest number of array) is the largest element which divide all array elements. So we take these two as left and right to perform binary search. Each time we get a middle sum and we want to use a helper function to see how many subarrays here when sum is mid. If this helper function returns a smaller value than m meaning we need more cut and right is responsible for (n - 1) cut(largest cut number), we need to shrink right to get more cut.
For the helper function, we need to find how many sub-arrays here where largest sum less than mid. So we initialize sum as 0 and count as 0(sub-arrays number). We loop through nums array and update sum to sum variable, if sum <= mid keep adding, else meaning sub-array sum reaches mid and cut + 1. So assign new coming element to sum for new searching and count ++. We finally return count
