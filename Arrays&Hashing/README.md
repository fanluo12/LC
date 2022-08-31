## 217. Contains Duplicate
Use hash set to loop through array. Once cannot add element to hash set then return false

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
