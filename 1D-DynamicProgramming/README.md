# 16 Total - 09/18/2022

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

## 647. Palindromic Substrings
Same as question 5 above to find palindrome substrings. For loop string and start searching for each index and regarding it as center. Consider odd and even length when searching and update to result

## 91. Decode Ways
Create dp array with one extra place length since we need to update last index to this extra place.
This dp array records how many possible ways for decoding of each index, so we initialize 0 and 1 index as 1 and 1 since one digit only has one situations.
For loop from 2 index, and get integer of substring based on indices. If we are in i index, we need to get integer of substring in (i - 2, i) and (i - 1, i). If these two integers satisfy with [0, 9] and [10, 26] range, we update them to i index of dp array.

## 322. Coin Change && 279. Perfect Squares
### 322
Create dp array of amount + 1 to represent change ways. We use MAX_VALUE to represent it could not be changes and fill dp array. We set dp[0] to 0
For loop from 0 to amount, each amount we nested for loop through coin, once amount - coin >= 0 means we can change this amount and we update dp[this amount] as minimum of itself and dp[this amount - coin] + 1 if dp[this amount - coin] is NOT MAX_VALUE(unchangeable)
### 279
Convert this question as you have amount as n, and you want to change n to coins, the coins concsist from 1^2 to Math.pow(n, 0.5)^2

## 152. Maximum Product Subarray
Large positive multiply large positive will get greater value. However, smaller negative value multiply smaller negative value would also get greater positive value. So we need to update positive product as large as we can, in the same time update negative product as smaller as we can. Each time looping we need to see if positive product * current value large or negative product * current value large

## 139. Word Break
Use hash set to store all strings from wordDict.
Create dp array to mark contains word or not.
For loop through string, marked each index as start. For each start index, for loop through end index which initiate as start + 1 until last. If hash set contains s.substring(start, end) NOT end + 1 since single character would possible needed, then mark as 1. If outer for loop meet not 1, continue to pass

## 300. Longest Increasing Subsequence
Reversely for loop, for each index, for loop from current position to end, once meet larger, update larger position with index number + 1 and update to result for largest value

## 343. Integer Break
Use arraylist to update result. Initialize 0 and 1 indices as 0 and 1.
The idea is loopting through from 2 to number, for each number, take 4 as example, we want to know product of (1, 3) larger or product of (2, 2) larger. So for each number, we search from 1 and number - 1 with left and right pointer. Each time we update max product of max(left, dp.get(left) * max(right, dp.get(right)) where dp.get(left or right) indicates this numbers largest product. We can use this product or this number whatever larger

## 368. Largest Divisible Subset
For loop through array, at each current index, loop through back. If previous index can be divided by current and count[prev] + 1 > count[cur](count array initialized at first. Each looping, count[cur] as 1 to update), we update count[cur] as count[pre] + 1 and set previous array[cur] = pre(previous array initialized at first, used to map cur with pre for the final result). After looping through current index, we can compare with max(initialize as 0), once greater than max, we can assign cur to final index(the last index of largest subset. Of course each time looping we assign -1 to this final index as a sign of end). When we finish loop, we have a final index as last element of result, and while it is not -1, we add nums[index] to arraylist and update index as previous array[index]
