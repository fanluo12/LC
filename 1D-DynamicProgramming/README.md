## 70. Climbing Stairs
Create dp array which length = n + 1 and initialize 0 and 1 index as 1.
For loop through array from index 2 and dp[i] = dp[i - 1] + dp[i - 2]

## 746. Min Cost Climbing Stairs
Create dp array which additional place to last and set it as 0. Then from dp.length - 3 index we can update until i equals to 0. Each time for loop we add next two indices minimum to current index until 0

## 198. House Robber
We cannot rob adjacent house, so we set a dp array of nums length. We set index 0 as nums[0] and index 1 as maximum of nums[1] and nums[0] since if we iterate through from index 2, if index 1 and 2 are same small our result would small. So index 1 MUST set as max of index 0 and 1

## 213. House Robber II
For loop through from 0 to -2 index and from 1 to -1 index respectively to update two results and compare

## 5. Longest Palindromic Substring
For loop through string and at each index, we start to search palindrome of left and right direction. Since palindrome has odd and even length, so we set left pointer as i and right pointer as i for odd length palindrome and left as i, right as i + 1 for even length palindrome. 
For each odd or even length palindrome search, we use while loop to prevent left and right in boundaries and left position character equals right character. Once we are in looping, update longest substring length and substring
