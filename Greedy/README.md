# 18 total - 12/04/2022

## 53. Maximum Subarray
Use two variables, res and tmp. res is initialed as Integer.MIN_VALUE to maximum res and tmp in next steps while tmp a running sum of elements in array.
For loop through array and use tmp to add each element. If tmp < 0 then assign 0 to tmp since negative value would be less if adding negative value so we need to start from 0 to record again the running sum.

## 55. Jump Game && 45. Jump Game II
### 55
We only need to see for each index, max destination could reach it or not. So we create a integer variable maxDestination = 0 to record max destination. For loop through array, if maxDestination < i, return false since cannot reach one certain index position. Then update maxDestination with maximum of itself and nums[i] + i. If maxDestination greater then array length, then return true

## 45. Jump Game II
We need to reach last index with minimum jump, so this is kind like dynamic programming with two pointers left and right
Take [2,3,1,1, 4] as an example, if we jump from first index with its maximum capacity, we need jump 3 times rather an optimized way. So this question need to evaluate each step to see under what circumatance can let right reach last index
Use while loop to track right to see if reaches end
In while loop, each time we initialize a maxDestination = 0, then we update left pointer with for loop until right to see maxDestination can be.
After loop through left to right we get a new destination and assign to right, so next while loop excutes will break. In the meantime we left++ and answer++

## 134. Gas Station
Sum up total gas and cost, if total gas less than total cost simply return true
For loop through gas(or cost) from 0 index. Use a variable total to record leftover gas. Then total += gas[i] - cost[i]. If total < 0 means cannot reach next gas station then assign 0 to total to reset. In the meantime, use another variable answer to record index and index should ++ since current not satisfy

##135. Candy
1. Create a result array and fill it with 1s
2. Loop through index i from 0 to length - 2, if array[i + 1] > array[i], result array[i + 1] = [i] + 1
3. Loop back from length - 1 to 1 since we want to update based on two side neighbors. Note that case [1,3,4,5,2], when reverse checking, [i - 1] > i, but we cannot assign [i - 1] = [i] + 1 since index 3 will be converted from 4 to 2. So we need to add a comparison which let res[i - 1] = Math.max(res[i - 1], 1 + res[i])

## 846. Hand of Straights
### Given hand = [1,2,3,6,2,3,4,7,8], groupSize = 3 and return true since hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
1. Use HashMap to record each element number
2. Use priority queue(pq) to record each element with ascending order
3. Under while(!pq.isEmpty()) loop, first take peek element(smallest element) as start. Then with for loop through start to (start + groupSize), if map didn't contains in this interval, return false, else map substract element with 1. If map.get(element in this interval) == 0, we need to see if this is the peek, aka head, if not, which means number chain broke, just return false

## 1899. Merge Triplets to Form Target Triplet
Use 3 variables a, b, c to compare and update to final answer
For loop through Triplets array, if all elements in triplet[i] is less than same index of target, we update a, b, c to the max of themselves and each index of triplet[i].
Finally we judge if [a, b, c] == target

## 763. Partition Labels
Since it's about indices, we use hash map to record last index of each character
We use variable size to track increasing size of character chain.
For loop string, identify each character's last index with a variable end. In the meantime size++ on each loop. If i== end, add size to array list

## 678. Valid Parenthesis String
Use leftMin and leftMax two variables to update brackets number
For loop through string, if character is '(', add 1 on two variables. If character is ')', minus 1 on two variables. What we need to do is track leftMax to see if it is less than 0, if so, return false. For leftMin, since may have '*', so once leftMin < 0 reset leftMin to 0. Based on these circumstance we can see the third judge of if statement is that once met '*', leftMin -- and leftMax ++

## 334. Increasing Triplet Subsequence && 414. Third Maximum Number
### 334
Use 2 variables, p1 and p2 which initialize as inf. For loop through array, if <= p1, assign it to p1, else if <= p2, assign it to p2, else return
### 414
Use 3 variables, first, second and third as long -inf. NOTE if we are not using long type, [1,2, -inf] will return 2 since our final check is thirdMax == -inf or not. For loop through array, if greater than first, assign second to third, first to second and nums[i] to first. If greater than seoncd and less than first, assign second to third and nums[i] to second. If greater than third and less than second, assign nums[i] to third 

## 605. Can Place Flowers
Expand original array for 2 place--one for head and one for tail and populate rest with original value. In this case we count expanded flower bed to see how many we can grow. Looping new expanded array, we judge if current position is 0 and its previous and next are also 0, in this case we can plant and minus n. We finally compare if n less than 0

## 665. Non-decreasing Array
case 1: [1, 7, 3, 4], at index 2 position, i-2 position can form a non decreasing with i, so we want to change 7 to make i-2, i-1, i non-decreasing for now
case 2: [4, 7, 3, 9], at index 2 position, since i - 2 is greater than i and [i-2, i -1] is non-decreasing, so we want to change i to i-1 to make i-2,i-1,i non-decreasing

## 881. Boats to Save People
We want to be greedy -- use minimum boats to save people. This will force us to load as much as each boat can within its limit
1. Sort array with ascending order first, and use two pointers, left and right to update
2. While left pointer less than right pointer, we need to load as many as each boat can, so we update left when left + right <= limit. This will ensure left as far as it can
3. Then after updating left, we need to add 1 for result and also update right since right-most people already been saved

## 926. Flip String to Monotone Increasing
1. Find all zeros, ie max zeros we need to flip, but this is not a optimally answer
2. Set one's number as 0, result as zeroes, but we need to reduce result
3. Loop through array, once meet '0', zeros - 1, means there are still zero's we need to flip, once meet '1', one +1, then update min(result, one + zeros)

## 1007. Minimum Domino Rotations For Equal Row
1. Count frequency array for each element in both tops and bottoms. When looping, when tops[i] == bottoms[i], plus 1 for union array
2. If tops[i] + bottoms[i](i -> 1-6) - unions[i] == length, this must be the result. We simply return smaller one minus union of this number

## 1029. Two City Scheduling
Create 3D array where arr[i][0] is 2nd city cost - 1st cost, arr[1] = 1st city cost, arr[2] = 2nd city cost. Sort 3D array with first index ascending order, meaning 2nd city cost is less than first. Looping through array, if current less than half place, add 2nd cost to result, else add 1st cost to result

## 1094. Car Pooling
1. Create an array representing all the pick up and drop locations. Loop through trips array, for trips[i], take trips[i][1], trips[i][2] as index from and to, then array[from] += trips[i][0], array[to] -= trips[i][0]
2. Define variable passenger number to 0. Looping through array, add current index number, ie how many passengers should in/out. Once passenger number greater than capacity, return false

## 1871. Jump Game VII
1. Use queue to store jumped positions. Initiate queue as 0
2. Each time poll a position i from queue, and search in range [max(i + minJump, max distance(initialize as 0) + 1), min(i + maxJump + 1, s.length())], once meet '0', offer to queue and if '0' position is length - 1, return true
