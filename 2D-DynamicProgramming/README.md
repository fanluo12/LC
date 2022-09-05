## 62. Unique Paths
Create same size 2D dp array and populate with 1. From 1 to row size - 1 and 1 to col size -1, dp[r][c] = dp[r - 1][c] + dp[r][c - 1]

## 1143. Longest Common Subsequence
Create dp array where rows = long string.length() + 1 and cols = short string.length() + 1.
For loop from r = 1 and c = 1, while long string[r - 1] == short string[c - 1], dp[r][c] = dp[r - 1][c - 1] + 1. Else dp[r][c] = max(dp[r-1][c], dp[r][c-1]
