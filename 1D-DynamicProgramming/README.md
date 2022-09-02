## 70. Climbing Stairs
Create dp array which length = n + 1 and initialize 0 and 1 index as 1.
For loop through array from index 2 and dp[i] = dp[i - 1] + dp[i - 2]

## 746. Min Cost Climbing Stairs
Create dp array which additional place to last and set it as 0. Then from dp.length - 3 index we can update until i equals to 0. Each time for loop we add next two indices minimum to current index until 0

## 198. House Robber
We cannot rob adjacent house, so we set a dp array of nums length. We set index 0 as nums[0] and index 1 as maximum of nums[1] and nums[0] since if we iterate through from index 2, if index 1 and 2 are same small our result would small. So index 1 MUST set as max of index 0 and 1
