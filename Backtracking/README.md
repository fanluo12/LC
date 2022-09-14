# 11 total - 09/11/2022

## 22. Generate Parentheses
Backtrack to generate parentheses. In backtrack function, use two parameters left and right to generate left and right parenthese. Initialize left and right as n and set end criteria is that left and right are both 0. In each backtrack process, left - 1 if generate "(" and right - 1 if generate ")"

## 93. Restore IP Addresses
Backtracking with current index, dots and current string. While current index reaches end and dots reaches 4, final list add result and return.
Take current index and left window of substring, for loop from current index until min(cur + 3, s.length()) to avoid "0.0.0.0" case. In for loop, judge if no leading 0 and integer of substring less than 255 and backtrack
