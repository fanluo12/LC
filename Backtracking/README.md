# 21 total - 11/02/2022

## 51. N-Queens
1. We use column set, positive diagnal set and negative diagnal set to record potential result
2, In backtrack, we need to update row variable. When row == n, we need to add board to result list.
3. In backtrack, we need to loop through column from 0 to n - 1, if current row and column in one of three sets above, we break single loop. Elase we add current row and column to set and mark position as 'Q'

## 79. Word Search
1. Since we need to judge concat string equals to word or not, we need a INDEX vairable of word
2. We loop through matrix, once satisfy backtrack(which returns to boolean) we return true
3. In backtrack method, we first check if INDEX reaches word.length(). Next we need to check if in the boundary or character not match or visited this position or not. Next we mark visiting position as true and start backtrack 4 directionally. Note if not satisfy 4 directions, we need to mark back

## 113. Path Sum II
Note we want root-left path which means left should have no children. So when backtracking, we first judge root is null or not, next we check if no left and right children and also targetSum is 0. If so, add path to result, else we search left and right recursively

## 140. Word Break II
1. Use hashset to store all words in wordDict
2. Backtracking. Once index reaches end of string, String.join(" ", path) then add to final arraylist
3. Loop through and make substring of string. Once set contains string, add to path and backtracking from next position

## 17. Letter Combinations of a Phone Number
Unlike 140, we don't need to use List<String> path to store tmp string, we only need permutations of keys. So we use a string to update result and do a kind-of nested loop to concat values of keys.
1. In backtrack method, once temporary string length equals to digits length, we add to result and return
2. Loop through digits, for loop through each values set of map.get(digits.charAt(i)) and do backtracking, no need to REMOVE LAST POSITION!!!

## 22. Generate Parentheses
Backtrack to generate parentheses. In backtrack function, use two parameters left and right to generate left and right parenthese. Initialize left and right as n and set end criteria is that left and right are both 0. In each backtrack process, left - 1 if generate "(" and right - 1 if generate ")"

## 93. Restore IP Addresses
Backtracking with current index, dots and current string. While current index reaches end and dots reaches 4, final list add result and return.
Take current index and left window of substring, for loop from current index until min(cur + 3, s.length()) to avoid "0.0.0.0" case. In for loop, judge if no leading 0 and integer of substring less than 255 and backtrack

## 473. Matchsticks to Square && 698. Partition to K Equal Sum Subsets
### 698. Partition to K Equal Sum Subsets
1. Check if could be divided by edges. If so, get edge length and sides[] array which represent each side
2. Sort array with descending order and backtrack
3. In backtrack, we check if start parameter reaches end of array. If so return true. Then loop through sides[] length to populate each side. If sides[i] + current array[start] <= edge length, we can backtrack from next position and if backtrack works, we return true. Remember to remove last, i.e. sides[i] - array[start]

## 526. Beautiful Arrangement
1. We use boolean array(range from 1 to n) to record each index whether can be divided or not. Also we need global variable count to update result
2. We use backtrack to update, the parameters we pass in are start(initialize as 1), n and visited array. In backtrack method, once start greater than n, we need to update result of count and return. 
3. Next for each START variable, we loop through from 1 to n, once not visited this number and mod is 0(2 mods), we can mark i as true and backtrack from START + 1

## 1239. Maximum Length of a Concatenated String with Unique Characters
1. Define global variable result to update max
2. In dfs method, We use noDuplicate helper method to check current string has duplicate or not. If no, update max result. Then we check once reaches the end of list, if there is still duplicate, if so return. Next looping from start to end, each time concat current string
3. For noDuplicate method, we fill char array to check if there is duplicate in string or not

## 1849. Splitting a String Into Descending Consecutive Values
We need to create a backtrack method, to get accumulated number as cur, and previous and check recursively
1. For backtrack() method, we need to put 3 parameters, original string s, previous number, we use WRAPPER CLASS DOUBLE since we can initiate as null, and start index initialized as 0
2. In backtrack, we need to construct each recursion's number, i.e. double cur = 0. Then loop from start index, construct cur with cur = cur * 10 + (s.charAt(i) - '0'). NOTE cur should less than 10000000000L
3. Then after constructed cur, we check if prev is null or not. If so, simply backtrack, else since prev is not null, we check cur == prev - 1 and i reaches end and backtrack() from next position

## 1980. Find Unique Binary String
We take opposite characters of nums[0][0], nums[1][1], nums[2][2]...i.e. if char is 1 we go 0
