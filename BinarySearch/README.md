# 22 total - 11/16/2022

## 4. Median of Two Sorted Arrays
1. We need 4 variables, index1(0) and index2(0) represents the position of arr1 and arr2, mid1 and mid2 updates result. If m(arr1.length) + n(arr2.length) is even, result will be (mid1 + mid2) / 2, otherwise will be mid2. So basically we need to find mid2
1. Loop through from 0 to (m + n) / 2
2. For each loops, we need to check 3 conditions, if index1 reaches end of arr1, if index2 reaches end of arr2 or if index1 and index2 in progress
3. We take third statement first, if index1 and index2 still in progress, then we need to update mid2, which if arr1[index1] < arr2[index2] then mid2 = arr[index1] and index1 ++ else mid2 = arr2[index2] and index2 ++
4. Once index1 or index2 reaches m or n and also we still in loop, this will have a situation like one array is finished and it is too short, we still need to traverse other one. In this case we need to update index2 if arr1 reached end or index1 if arr2 reached end. In this time we still need to update mid2. But what if total length is even?
5. To solve this problem in 4, we need to assign mid1 = mid2 at very first of loop, in this time for example, [1,2] and [3, 4]. After statement 3, arr1 reaches end and mid2 = 2, however we still have one loop left, so at very first we assign mid1 = mid2 which is 2 and update arr2 and assign mid2 = 3. So final result is (2 + 3) / 2

## 441. Arranging Coins
1. Take left = 1 and right = n pointer as long type since we need to calculate sum from 1 to mid and this sum coule out of integer range
2. In binary search, we find mid and calculate sum of mid. If this sum greater than n, means last row is not full, so right = mid - 1 Otherwise update left and also update result which is the max of itself and mid

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
1. Use left and right pointer to binary search.
2. In binary search, if left position already less than right, which means left is what we looking for and simply return it. Then we find middle index of left and right. Note there are few situations:
1. [2, 1], mid is 0. nums[mid] should >= nums[left] and then update left to mid + 1
2. [3, 1, 2], mid is less than right. In this time right should be mid
### 81
Same as 153 and just return boolean value. Use left and right pointer to find middle pointer. In while(left <= right) loop, if we find middle pointer is target, then simply return true. If left < mid, we need to judge target belong to [left, mid] or not. Same as left > mid
### **154
Similar to 153, in binary search we check if left < right. If so, meaning already satisfy criterial and return left. Since we're going to find left, once we find middle pointer and arr[mid] >= arr[left], we need to update left + 1 rather left = mid + 1 since mid + 1 could also be duplicate one

## 34. Find First and Last Position of Element in Sorted Array
This is one main different from binary search. When we find nums[mid] == target, we update left and right pointer as mid and update to both direction to find left most and right most indices which equals to target.
After we find nums[mid] == target, we assign left and right pointer as mid and use while loop to update them

## 69. Sqrt(x)
Use binary search to find square root. Left as 1 and right as x. Each time we find mid, we judge if mid^2 <= x and (mid + 1)^2 > x and return

## 278. First Bad Version
Elements after first bad version would be bad version so we need to find as left as we can
1. We use left = 0 and right = n to binary search
2. Each time we find mid in binary search, if it is bad by API check, we need to find whether if there exists in left side, so we update right as mid. Else left = mid + 1

## 367. Valid Perfect Square
We need to avoid integer out of range problem when we binary search
1. We can use long type for mid and check if mid^2 is num then return true
2. We can also use tmp = num / mid and compare tmp and mid to see if they equal or not. But remember, int tmp can be fake since 5 /2 = 2, so we need to add additional remainder = 0 to check together

## ** 410. Split Array Largest Sum
We use two extreme situations to perform binary search. The largest sum is the sum of all elements which no cut and smallest sum(although comparing to largest solution, it is the largest number of array) is the largest element which divide all array elements. So we take these two as left and right to perform binary search. Each time we get a middle sum and we want to use a helper function to see how many subarrays here when sum is mid. If this helper function returns a smaller value than m meaning we need more cut and right is responsible for (n - 1) cut(largest cut number), we need to shrink right to get more cut.
For the helper function, we need to find how many sub-arrays here where largest sum less than mid. So we initialize sum as 0 and count as 0(sub-arrays number). We loop through nums array and update sum to sum variable, if sum <= mid keep adding, else meaning sub-array sum reaches mid and cut + 1. So assign new coming element to sum for new searching and count ++. We finally return count

## 1095. Find in Mountain Array
1. Find peak position, if peak is target then there would be no more target, just return peak
2. Check from 0 to peak to find target
3. If there is no result for the check above, check from peak + 1 to the end

## 1300. Sum of Mutated Array Closest to Target
1. Find the max and sum of array. If sum == target, then return max value of array since we don't need to change any value of array
2. Use min = 0 and max to binary search, each time when we find mid, we use helpepr function to get mutated sum of array(this would calculate sum of array when value greater than mid would all counts as mid). If this mutated sum > target, max = mid - 1, else min = mid + 1
3. After we update max or min, we update difference of mutated sum and target. If this difference is less than previous difference or equal but mid is less than result(initialize as 1 since 1 is the smallest case), we update result as mid and difference as mutated sum - target

## **1898. Maximum Number of Removable Characters
1. We create char array to modify removed characters
2. We use binary search to find mid, ie. how many characters we remove this round. When we find mid, we substitute on char array with '*'
3. After removing those characters, we use helper function to check p is subsequence of char array. If so, meaning first mid element worked, now we focus on[mid + 1, right] range, else we set back of removed characters and set right to mid - 1
