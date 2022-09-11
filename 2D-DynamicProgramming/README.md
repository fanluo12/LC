# 8 total-09/11/2022

## 62. Unique Paths
Create same size 2D dp array and populate with 1. From 1 to row size - 1 and 1 to col size -1, dp[r][c] = dp[r - 1][c] + dp[r][c - 1]

## 1143. Longest Common Subsequence
Create dp array where rows = long string.length() + 1 and cols = short string.length() + 1.
For loop from r = 1 and c = 1, while long string[r - 1] == short string[c - 1], dp[r][c] = dp[r - 1][c - 1] + 1. Else dp[r][c] = max(dp[r-1][c], dp[r][c-1]

## 494. Target Sum
Use hash map to update result. First put (0, 1) to map.
For loop nums array, each time initiate a new sub map and put map.key - current position and map.key + current position to it. When finishing each loop update submap to map.

## 97. Interleaving String
Create 2D dp boolean array.
For loop row and column, mark (0, 0) as true. Then once row(col) greater than 0 and s1(s2)[i - 1][j]([i][j - 1]) is true and s1(s2)[i - 1]([j - 1]) == s3[i + j - 1], assign true
