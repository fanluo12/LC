# 16 total-10/19/2022

## 62. Unique Paths && 63. Unique Paths II
62
Create same size 2D dp array and populate with 1. From 1 to row size - 1 and 1 to col size -1, dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
63
Create same size 2D dp array. Loop through first row and col and populate with 1. If there is obstacle in first row and col, break.
For loop through, once meet obstacle, continue to jump, then dp[r][c] = dp[r - 1][c] + dp[r][c - 1]

## 1143. Longest Common Subsequence
Create dp array where rows = long string.length() + 1 and cols = short string.length() + 1.
For loop from r = 1 and c = 1, while long string[r - 1] == short string[c - 1], dp[r][c] = dp[r - 1][c - 1] + 1. Else dp[r][c] = max(dp[r-1][c], dp[r][c-1]

## 494. Target Sum
Use hash map to update result. First put (0, 1) to map.
For loop nums array, each time initiate a new sub map and put map.key - current position and map.key + current position to it. When finishing each loop update submap to map.

## 97. Interleaving String
Create 2D dp boolean array.
For loop row and column, mark (0, 0) as true. Then once row(col) greater than 0 and s1(s2)[i - 1][j]([i][j - 1]) is true and s1(s2)[i - 1]([j - 1]) == s3[i + j - 1], assign true

## 44. Wildcard Matching
Create boolean array of extra 1 length and initiate (0, 0) as true. For p stirng, since it contains *, we loop column to update next column as last column if it is '*'.
Normal for loop through row and column from (1, 1) place. Once s[i - 1] == p[j - 1] or p[j - 1] == '?', result equals to (i - 1, j - 1) place. If p[j - 1] is '*', meaning things after it would match, so simply same as result of (i - 1, j) or (i, j - 1) place. Else fill with false

## 64. Minimum Path Sum
Use prevSum variable to record previous sum. For loop through array, if row and col are both 0, initialize prevSum as 0. If row == 0, prevSum equals to last column, which is array[r][c - 1]. Same for col. If not (0, 0) or first row or first col, prevSum = min((r-1, c), (r, c-1)). Update array[r][c] = prevSum + grid[r][c]

## 403. Frog Jump
Use 2D boolean array which row is n and col is n + 1. Column represent for each unit, how far it can goes, so for the last index the farthest would be n + 1. We initialize dp[0][1] = true representing 0 index can reach 1 index.
For loop(int end) through all indices, for each index, use nested for loop(int start) traverse from 0 to i - 1. Each time calculate distance between start and end. If difference less than 1 or greater than length or dp[start][distance] is not true(meaning start cannot reach end), we use continue to break this single loop. If we can pass the judgement, we mark dp[end][distance] as true since this is how end can go so far(at least distance since last reach end with distance and end can at least go this distance). Of course we need to mark dp[end][distance - 1](if distance greater than 1) and dp[end][distance + 1](if distance less than length). After marking, if end reaches last index, return true

## 718. Maximum Length of Repeated Subarray
Create 2D dp array with extra row and column. Looping row and column, if i - 1 == j -1, then dp[i][j] = dp[i - 1][j - 1] + 1

## 1277. Count Square Submatrices with All Ones
1. Count first row and column of single square
2. DP way. Start looping from (1, 1) until end, add each index value to result. Note that once we meet 1 at (i, j), we check (i - 1, j), (i, j - 1) and (i - 1, j -1) whether all greater than 0, if so, we add minimum of them to (i, j) and add this updated index value to result
