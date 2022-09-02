## 70. Climbing Stairs
Create dp array which length = n + 1 and initialize 0 and 1 index as 1.
For loop through array from index 2 and dp[i] = dp[i - 1] + dp[i - 2]

## 746. Min Cost Climbing Stairs
Create dp array which additional place to last and set it as 0. Then from dp.length - 3 index we can update until i equals to 0. Each time for loop we add next two indices minimum to current index until 0
