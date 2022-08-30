## 217. Contains Duplicate
Use hash set to loop through array. Once cannot add element to hash set then return false

## 242. Valid Anagram
Use hash map to store character occurance time. 
Loop through string, add 1 for one string's character and minus for other's.
Finally loop through key set of map, if there has element occurance not equal to 0 return false

## 1. Two Sum
Use hash map to record elements indices of array. Loop through array, if map contains (target - nums[i]) then return new array
