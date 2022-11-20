## 301. Remove Invalid Parentheses
Use set and queue to store valid string. While queue is not empty, poll string of it and judge by isValid function. If it is valid, result arraylist add it. If it is not valid, loop through it and make new strings divided by looping index and add to queue and set.
For isValid function, simply define a count variable and add 1 to count if looping ( and -1 for ). Finally judge if count == 0

## 542. 01 Matrix
1. Create result matrix and put everything inside as -1
2. Loop through res, once element is 0, put position(row, col) to queue
3. Use queue to do BFS. Each time poll out (r, c) and find (newRow, newCol) 4 directionally. Note we need to safisfy boundary criteria and (newRow, newCol) must be -1. In this case we update res[newRow][newCol] = res[r][c] + 1 and put (newRow, newCol) to queue

## 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
1. We use two queue, maxQ and minQ to store element with descending and ascending order
2. We use two pointers, left and right to update max window.
3. In sliding window algorithm, we update right windwo. Once nums[right] >= maxQ.peekLast() or nums[right] <= minQ.peekLast(), we use pollLast() to remove those not greater or smaller enough elements and add right position to two queues.
4. Once we poll and add, we compare minQ and maxQ, i.e. maxQ.peek() - minQ.peek(), once difference > limit, means we need to update left window, and once left > minQ.peek() or left < maxQ.peek(), we need to poll them out
5. After we updating left window, we update result of current window size
