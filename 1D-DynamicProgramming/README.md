# 27 Total -10/16/2022

## 70. Climbing Stairs
Create dp array which length = n + 1 and initialize 0 and 1 index as 1.
For loop through array from index 2 and dp[i] = dp[i - 1] + dp[i - 2]

## 746. Min Cost Climbing Stairs
Create dp array which additional place to last and set it as 0. Then from dp.length - 3 index we can update until i equals to 0. Each time for loop we add next two indices minimum to current index until 0

## 198. House Robber
We cannot rob adjacent house, so we set a dp array of nums length. We set index 0 as nums[0] and index 1 as maximum of nums[1] and nums[0] since if we iterate through from index 2, if index 1 and 2 are same small our result would small. So index 1 MUST set as max of index 0 and 1

## 213. House Robber II && 740. Delete and Earn
### 213
For loop through from 0 to -2 index and from 1 to -1 index respectively to update two results and compare
### 740
Same as house robbers, we need to compare rob current index or rob previous and next. Use frequency array to store each element total sum and dp array to loop. Initialize dp[0] and dp[1], then from index 2, dp[i] is the max of freq[i] + dp[i -2] and dp[i - 1]

## 5. Longest Palindromic Substring
For loop through string and at each index, we start to search palindrome of left and right direction. Since palindrome has odd and even length, so we set left pointer as i and right pointer as i for odd length palindrome and left as i, right as i + 1 for even length palindrome. 
For each odd or even length palindrome search, we use while loop to prevent left and right in boundaries and left position character equals right character. Once we are in looping, update longest substring length and substring
1. For odd length palindrome
....(L & R)....
...L.R...
..L...R..
2. For even length palindrome
...LR...
..l..R..
.l....R..

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

## *368. Largest Divisible Subset
For loop through array, at each current index, loop through back. If previous index can be divided by current and count[prev] + 1 > count[cur](count array initialized at first. Each looping, count[cur] as 1 to update), we update count[cur] as count[pre] + 1 and set previous array[cur] = pre(previous array initialized at first, used to map cur with pre for the final result). After looping through current index, we can compare with max(initialize as 0), once greater than max, we can assign cur to final index(the last index of largest subset. Of course each time looping we assign -1 to this final index as a sign of end). When we finish loop, we have a final index as last element of result, and while it is not -1, we add nums[index] to arraylist and update index as previous array[index]

## 518. Coin Change II && 377. Combination Sum IV
One BIGGEST DIFFERENCE between them is that for 377, temporary sum can add new element from 0 index, which means, we need to for loop through each number in [1, target], and each time we loop through all numbers in nums array to check if we can sum up to target(eg, results can contain duplicate like(1,2,1), (1,1,2)). However, for 518, there is no duplicate, so we need to loop through all coins, for each coin, we find all the possible results by nested loop from [coin, amount]

## * 416. Partition Equal Subset Sum
Take [2,2,3,5] as example, it cannot been paritioned. The target we looking for is 6 so we created a boolean array which length is target + 1(last index is exactly 6). For loop through each element, for each element, we use another loop to traverse from [target, cur element] and fill dp[i] = dp[i - outer for loop element] || dp[i]. The idea is mark changeable number as true. So the first loop we take 2 and only dp[2] is true meaning 2 can be changeable. Second we take 2 for loop, since last time 2 been marked true, and this time dp[4] can be mark true. So the same with dp[3] and dp[5], and dp[6] is false meaning we cannot parition

## 472. Concatenated Words
1. We sort words array with ascending order of each string length
2. We initialize a empty string hash set for adding
3. Loop through words array, if satisfy boolean helper function, then add to result array list. Each time finish helper dfs function add current word to set
4. For dfs function, first we need to judge if set is empty or not for first case. If empty return false. Then we judge ending criteria ie start index reaches current word length, if so return true. Next we loop through end index from current index + 1 to string.length() + 1, if set contains substring of[start, end] and satisfy dfs end index, return true

## 983. Minimum Cost For Tickets
1. Create dp array where length equals last travel day of days array plus 1
2. Creat boolean array where each travel day of days array marked true
3. Looping from 1 to last travel day of dp array, if it is false in boolean array, then assign previous value to current(dp[i] = dp[i -1]). If it is travel day, then dp[i] = min(dp[i - 1] + cost[0], dp[i - 7] + cost[1], dp[i - 30] + cost[2]), note since i minus 1 or 7 or 30 may less than 0, so we use dp[max(0,i - 7 or 1 or 30)]

## **1043. Partition Array for Maximum Sum
1. Create dp array representing each index current max partition sum. We first find for first k element, each step max sum. For example, arr = [1,15,7,9,2,5,10], k = 3, so dp = [1, 30, 45,...]
2. After we find first k max sum, we loop from k to the end. Each time looping, we define a variable called partitionMax. This would find max value of k window of [current - k, current] which means we need to look back to see the max of previous(including current). So we nest loop k times from 0, and partitionMax would update by max arr[i - j] in nested loop ]. For each time searching partitionMax, we also see if we need to change previous sum. We find previous sum by dp[i - j - 1](kind of like prefix sum), we update current index with max of itself and previous sum + (j + 1) * partitionMax

## 118. Pascal's Triangle && 119. Pascal's Triangle II
Loop through from 0 to numRows - 1, initiate an empty list for each level. Then nested loop through index j from 0 to i, if j is 0 or j == i, level arraylist add 1, else add previous level (j - 1) + (j)

## **132. Palindrome Partitioning II
1. Use 2D boolean array to represent i == j or not to judge palindrome
2. Use 1D dp array to update curs
3. For loop right window through each position, and each time minimum cut should be the number of index. Then for each index, nested for loop left window from 0, once left and right are equal, mark 2D array[left][right] = true and update minimum cuts to minimum of iteself and dp[left - 1] + 1 if left is not 0 else 0, and update this cuts to dp[right]
