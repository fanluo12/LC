# 14 total - 09/18/2022

## 113. Path Sum II
Note we want root-left path which means left should have no children. So when backtracking, we first judge root is null or not, next we check if no left and right children and also targetSum is 0. If so, add path to result, else we search left and right recursively

## 22. Generate Parentheses
Backtrack to generate parentheses. In backtrack function, use two parameters left and right to generate left and right parenthese. Initialize left and right as n and set end criteria is that left and right are both 0. In each backtrack process, left - 1 if generate "(" and right - 1 if generate ")"

## 93. Restore IP Addresses
Backtracking with current index, dots and current string. While current index reaches end and dots reaches 4, final list add result and return.
Take current index and left window of substring, for loop from current index until min(cur + 3, s.length()) to avoid "0.0.0.0" case. In for loop, judge if no leading 0 and integer of substring less than 255 and backtrack

## 473. Matchsticks to Square && 698. Partition to K Equal Sum Subsets
### 698. Partition to K Equal Sum Subsets

## 1239. Maximum Length of a Concatenated String with Unique Characters
1. Define global variable result
2. Backtrack helper function, first judge if there is no duplicate for current concatenation string with helper function and update max length. Next if index reaches end or contains duplicate, return. Then for loop through array list, concat strings to backtrack
3. Define duplicate judgement function, input current concat string and use letter array to represent. If letter array digit more than 1 then return false
