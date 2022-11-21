## 71. Simplify Path
1. Split string with "/". In this case convert valid path to string array
2. Loop through string array and add string to queue if string is not empty or ".", otherwise we need to poll the last elements from queue
3. Use stringbuilder to append "/" + queue.poll(). If queue is empty just return "/"

## 301. Remove Invalid Parentheses
Use set and queue to store valid string. While queue is not empty, poll string of it and judge by isValid function. If it is valid, result arraylist add it. If it is not valid, loop through it and make new strings divided by looping index and add to queue and set.
For isValid function, simply define a count variable and add 1 to count if looping ( and -1 for ). Finally judge if count == 0

## 542. 01 Matrix
1. Create result matrix and put everything inside as -1
2. Loop through res, once element is 0, put position(row, col) to queue
3. Use queue to do BFS. Each time poll out (r, c) and find (newRow, newCol) 4 directionally. Note we need to safisfy boundary criteria and (newRow, newCol) must be -1. In this case we update res[newRow][newCol] = res[r][c] + 1 and put (newRow, newCol) to queue

## 752. Open the Lock
1. Use deadends set to store all deadends and check if target if one of them
2. Use 2 queues, lock and steps which store current lock and steps. Initiate them with "0000" and 0
3. Do BFS algorithm, each time poll 2 queues. Once polled lock is target then return polled step, otherwise if polled lock is a deadend then continue to break single loop
4. Loop through 4 indices, and choose digit up and down. For digit up, is current index is 9 and assign 0 otherwise digit + 1. Same for digit down
5. Once we created substring of current lock, i.e. (0, i) + digitUp(or digitDown) + (i + 1), we check if in visited set or not. If not, put it to visited set and 2 queues

## 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
1. We use two queue, maxQ and minQ to store element with descending and ascending order
2. We use two pointers, left and right to update max window.
3. In sliding window algorithm, we update right windwo. Once nums[right] >= maxQ.peekLast() or nums[right] <= minQ.peekLast(), we use pollLast() to remove those not greater or smaller enough elements and add right position to two queues.
4. Once we poll and add, we compare minQ and maxQ, i.e. maxQ.peek() - minQ.peek(), once difference > limit, means we need to update left window, and once left > minQ.peek() or left < maxQ.peek(), we need to poll them out
5. After we updating left window, we update result of current window size
