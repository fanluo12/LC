# 16 total - 09/18/2022

## 217. Contains Duplicate && 219. Contains Duplicate II
### 217
Use hash set to loop through array. Once cannot add element to hash set then return false
### 218
Take. k as a sliding window. For loop through array and put elements to hashset. If window size greater than k, remove i - k - 1 element from set. If cannot add(means duplicate in k window) then return

## 242. Valid Anagram
Use hash map to store character occurance time. 
Loop through string, add 1 for one string's character and minus for other's.
Finally loop through key set of map, if there has element occurance not equal to 0 return false

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

## 49. Group Anagrams
### Input: strs = ["eat","tea","tan","ate","nat","bat"]
### Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
For each string of strs, we created a character array and assign 26 length to it. Then we fill characters of each string to character array to get a string-value. We put string-value into map with responding string to find anagrams

# NOT FROM NEETCODE
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

# HARD 41. First Missing Positive
For loop through array, trying to put nums[i] == i + 1

## 149. Max Points on a Line
Use atan2() is an inbuilt method in Java that is used to return the theta component from the polar coordinate
