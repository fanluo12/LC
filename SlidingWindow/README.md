# 11 total - 09/18/2022

## 3. Longest Substring Without Repeating Characters
### Given a string s, find the length of the longest substring without repeating characters.
Identify left pointer and for loop right pointer of string to update window. Use hash set to store unduplicate characters. Once hash set contains right character means already has duplicate and left pointer position must be the duplicated, so under this case remove left position character from set and update left pointer.

## 424. Longest Repeating Character Replacement
### Change character at k most times to format longest substring contains same letter 
Identify left pointer and for loop right pointer through string. Use map to store occurance of right pointer character and update max occurance of character. If window size > max + k, means we can replace in this window and in the meantime update left and remove left pointer character

## 567. Permutation in String
### Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
Use hash map to store character occurence string s1
For loop through s2, once map contains key, map put occurance - 1 and when its value is 0 means we have eliminated a key and we adding 1 to result variable. Result variable also in for loop to judge once its equals to map.size(), we return true since all elements been found.
In for loop, we have these situations, 1. we found s1 at first s1.length() position. Under this situation with last step we can easily return true since map size equals to result. Once our loop index i greater than s1.length(), to avoid un-consecutive case, in the meantime we need to see if (i - s1.length()) is 0 in map. If its value is 0, means current window is wrong and we need to update window and re-add to result since it has been deducted. Then we put map + 1 for its value

## 76. Minimum Window Substring
Use left pointer and for loop through right pointer
Declare 2 variables, minLeft = 0 and minLen for final substring
Use hash map to store t string character occurance
In for loop, if we find map contains key of right pointer position, map put -1 for this position's character. Once right position still >= 0 we add 1 to count variable. When count == t.length(), we need less window we have. So if the new window size now(right - left + 1) < minLen means we can update minLen to new window size and update minLeft as left. In the meantime, we can update left pointer while count == t.length() and once map contains left key, map put +1 to this key and -1 to count since new window need to update


## 239. Sliding Window Maximum
For loop through array and use deque to store indices, when deque is not empty and reaches k, pop first element of deque
When deque is not empty and new coming position is greater than last, pop last element
Once looping index greater than k - 1, update answer array with head element of deque

## 1004. Max Consecutive Ones III
Use numZeros to count 0 of nums array.
Use left = 0 to represent left window and for loop through right window of array
Once meet 0 numZeros ++. Once numZeros greater than k, update left window. In the meantime we need to check if left window is 0 then numZeros --
Update max while numZeros <= k

## 438. Find All Anagrams in a String
Use 26-digit integer array to represent p. Loop through s with right window and put character to another 26-digit array. Once window size is equal to p length(left window initialize as 0), we judge if Arrays.equals(two integer array) and update result to arraylist. If not equal but window size is p length, update left window and remove character of left window

## 904. Fruit Into Baskets
In this question, we have to select two different number in array with largest distance between them. So we use left and right pointer both from 0 representing sliding window. We use hashmap to store index of each elemtn, once hashmap size greater than 2, we find mininum of values which would give us a index of window first element, then left window updated to index + 1. Outside we update final result of window size and update right pointer

## 1423. Maximum Points You Can Obtain from Cards
Take [0,1,2,3,4,5,6,7,8] and k = 3 as example. First we compute sum of first k, ie [0,1,2],3,4,5,6,7,8, then we slide window on left direction, window becomes 0,1],2,3,4,5,6,7,[8 and update max sum

## 1838. Frequency of the Most Frequent Element
1. Sort array first. Initiate left and right window from 0 index and temporary sum as 0
2. Update right window and sum. Once num[right] * length for now > sum + k, meaning if we change all numbers in [left, right] window to nums[right], there wou't be enough k for it, so we need to update left window

## 1984. Minimum Difference Between Highest and Lowest of K Scores
1. Sort array first, take left window as 0, right window as k - 1
2. Update result as minimum of nums[right] - nums[left], update left and right window in the mean time
