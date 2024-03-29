# 52 total - 10/26/2022

## 219. Contains Duplicate II
1. Method1(hashset)Take k as a sliding window. For loop through array and put elements to hashset. If window size greater than k, remove i - k - 1 element from set. If cannot add(means duplicate in k window) then return
2. Method2(hashmap)Loop through array andp put index of element to hashmap. Once map containskey and the difference is less than k, return true

## 1. Two Sum
Use hash map to record elements indices of array. Loop through array, if map contains (target - nums[i]) then return new array

## 238. Product of Array Except Self
Same idea to running sum, we first loop through from left to right, using pointer1(initialize as 1) to update product(each time arr[i] * pointer1 then pointer1 * arr[i]).
After we finished first loop, we use second for loop through from right to left, using pointer2(initialize as 1) to update product(each time arr[i] * pointer2 then pointer2 * arr[i])

## 36. Valid Sudoku
For loop throught each row, under each for loop, loop throught each columns
In outer for loop, when looping each row, initialize 3 sets- row set, columns set and sub-box set
In inner for loop, check if non-null element can be add to row set(!rowSet.add(board[r][c]) -> return false), check if non-null element can be add to column set(!rowSet.add(board[c][r]) -> return false) and check if non-null element can be add to sub-box set(!sub-box-set.add(board[R][C]))
How to get R, C for sub-box? Under r and c loop, initialize row = (r/3)*3, col = (r % 3) * 3, then R = row + c / 3, C = col + c % 3

## 49. Group Anagrams && 387. First Unique Character in a String && 389. Find the Difference && ** 395. Longest Substring with At Least K Repeating Characters ## 242. Valid Anagram ## 1189. Maximum Number of Balloons
### 49
#### Input: strs = ["eat","tea","tan","ate","nat","bat"]
#### Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
For each string of strs, we created a character array and assign 26 length to it. Then we fill characters of each string to character array to get a string-value. We put string-value into map with responding string to find anagrams
### 387
Fill integer array with character of string - 'a' and find first 1 in this array
### 389. Find the Difference
Fill integer array with t[char - 'a'] ++, and s[char - 'a'] --. Then the index with 1 is the one we looking for
### **395. Longest Substring with At Least K Repeating Characters
The idea is split array with less than k character, for example, string is aaabccc and k is 3, we split to string arrays [aaa, ccc] to find recursively.
1. We use char array to find frequency of string and initialize a char splitChar as 0
2. Looping through frequency array and break as soon as we find first character to split
3. We split string to string array by split() method, and recursively update result max. The result part can be confusing since we compare res(initialize as 0) to function(substring, k). The idea is if we cannot find break split character we simply return to current string length, so this is the end of recursion
### 242. Valid Anagram
Use letter array to ++ for s and -- for t. Loop again and once meet non-zero return false
### 1189. Maximum Number of Balloons
Remember we cannot use one letter array to represent balloon and update min by traversing "balloon" since balon case. We need to use two array, and dived single l count array to right answer l

## 283. Move Zeroes
Define a variable-cur to represent 0. For loop through array, once meet nums[i] != 0, if i is not same as cur, which means before i(identified not 0) there has 0 so switch them. Outside loop update cur.

## 189. Rotate Array
nums = "----->-->"; k =3
result = "-->----->";

reverse "----->-->" we can get "<--<-----"
reverse "<--" we can get "--><-----"
reverse "<-----" we can get "-->----->"

## 128. Longest Consecutive Sequence
Use set to store all elements.
For loop through set. If current element's previous not in set, we take this one as start and use a pointer to represent it. While set contains this pointer + 1, pointer ++ and calculate max of pointer - current element

## 41. First Missing Positive
### example1: [-1,4,2,1,9,10] -> [1,2,-1,4,9,10], return 3
### example2: [7,8,9,10,11] -> return 1
The idea is loop through array, trying to put nums[i] == i + 1, ie [1,2,3,4,...] and loop again, once meet i + 1 != nums[i] return
1. Take [-1,4,2,1,9,10] as example, finally we need to get [1,2,-1,4,9,10] and return 3. We loop through each index first, and take nums[i] as INDEX. While INDEX between [0, length] and num[INDEX - 1] != nums[i], we swap, so when looping to 1, we get [-1,1,2,4,9,10] at first, then [1, -1,2,4,9,10]

## 149. Max Points on a Line
1. For each point, we need to go through all other points except itself and put k frequency to hashmap. Note when we put k to hashmap, we need to update result by map.get(k) + 1 since we need to count point itself
2. We Use atan2() which is an inbuilt method in Java that is used to return the theta component from the polar coordinate, in other words, give us k we want. The way to use is call Math.atan2(x2 - x1, y2 - y1)

## 287. Find the Duplicate Number && 448. Find All Numbers Disappeared in an Array
### 287
Very fresh method. We want to find duplicate number from array. Array length is n and all number from 1 to n. So we can mark visited number as index, and put index-based element as negative. Then once we meet an element which is negative we can simply find result. 
### 446
Same as 287, we take absolutely value of each number as index, and num[index] = -Math.abs(nums[index]) since there may duplicate number and may cause negative value back to positive value for intervention. Then we use array list to record positive value

## 398. Random Pick Index
Use Random()
```
Random rand = new Random();
List<Integer> list = Arrays.asList(1,2,3,4,5);
int randomIndex = rand.nextInt(list.size())
```
## 409. Longest Palindrome
We don't need to know the permutation of palindrome, we just need a hash set to store duplicate element. Loop through string, once character in set, means we have two of them and can make palindrome, we remove them and update count. If hash set remains element, result would be odd palindrome(count * 2 + 1) else count * 2

## 454. 4Sum II
Use hash map to store the frequency of sum for nums1 and nums2. Loop through nums3 and nested loop through nums4, if their -sum exists in map, update final result

## 525. Contiguous Array
For loop through nums, use hash map to update current sum(if meet 0, minus 1, if meet 1, add 1). Once current sum is 0, update max length as i + 1. If map contains current sum, update max of current index minus map.get(curSum) and max length

## 763. Partition Labels
1. Use hash map to store farthest index of each character
2. For loop through string, each time variable size ++ and get farthest index of current character. Once looping index is same as farthest, add to array list and initial farthest index

## 953. Verifying an Alien Dictionary
The question give the order of letters, and words in array where words should in ascending order(first compare 1st letter, if same , then compare 2nd, 3rd...so on and so far). So we use hashmap to store the order of each letter and use a helper function to compare any two words in array in for loop.
For the helper function, we first get length of each two word, and looping them together. Once we meet two position which not same, if first letter greater than 2nd return fasle...After comparing, even they same for temporary, we still need to consider length difference situation, ie app and apple, so the length defined works now, we compare length and return false if longer one comes ahead

## 1048. Longest String Chain
1. Sort array with string length ascending order
2. Use hashmap to store longest chain. For loop through each word, for each word, delete one letter for each index every time and make a new combination. If map contains this new string key, then add 1 to temporary result and put to map

## 1299. Replace Elements with Greatest Element on Right Side
No need stack or some special data structures. We define a right max variable as -1, and loop through array from back. When traversing, we define new max value which is the max of right max and arr[i], and set arr[i] = right max, right max = new max

## 1365. How Many Numbers Are Smaller Than the Current Number
Make frequency array of all elements in nums. Then update each index of adding previous value. Create a new result array, for each element in nums, take it as index in frequency array, and find previous position. Note when nums[i] = 0 we cannot create -1, simpy add 0 to result

## 290. Word Pattern
1. Conert longer string to string array and judge length of array and pattern first
2. Use hashmap to store (pattern[i], array[i])
3. Loop through characaters in pattern. If map not contains key, we need to judge whether if map contains values or not before we put key to map. Else we need to check map.get(char) == array[i] or not

## 349. Intersection of Two Arrays && 350. Intersection of Two Arrays II
Find intercsection of two arrays. The different is 349 asks to find unique duplicate and 350 asks to find all intersections.
### 349
We use hashset to store unique of an array and another set to store intersections when looping the other array
### 350
We use hashmap to store number and frequency of an array, and when looping another array, once map contains key and value greater than 1, add to arraylist and convert arraylist to array
