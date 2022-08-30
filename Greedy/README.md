## 53. Maximum Subarray
Use two variables, res and tmp. res is initialed as Integer.MIN_VALUE to maximum res and tmp in next steps while tmp a running sum of elements in array.
For loop through array and use tmp to add each element. If tmp < 0 then assign 0 to tmp since negative value would be less if adding negative value so we need to start from 0 to record again the running sum.

## 55. Jump Game
Declare a integer variable maxDestination = 0 to record max destination
For loop through array, if maxDestination < i, return false since cannot reach one certain index position. 
Update maxDestination with maximum of itself and nums[i] + i
If maxDestination greater then array length, then return true

## 45. Jump Game II
We need to reach last index with minimum jump, so this is kind like dynamic programming with two pointers left and right
Take [2,3,1,1, 4] as an example, if we jump from first index with its maximum capacity, we need jump 3 times rather an optimized way. So this question need to evaluate each step to see under what circumatance can let right reach last index
Use while loop to track right to see if reaches end
In while loop, each time we initialize a maxDestination = 0, then we update left pointer with for loop until right to see maxDestination can be.
After loop through left to right we get a new destination and assign to right, so next while loop excutes will break. In the meantime we left++ and answer++

## 134. Gas Station
Sum up total gas and cost, if total gas less than total cost simply return true
For loop through gas(or cost) from 0 index. Use a variable total to record leftover gas. Then total += gas[i] - cost[i]. If total < 0 means cannot reach next gas station then assign 0 to total to reset. In the meantime, use another variable answer to record index and index should ++ since current not satisfy
