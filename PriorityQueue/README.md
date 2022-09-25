# 5 total - 09/11/2022

## 347. Top K Frequent Elements
Use map to store each integer's occurance
Use priority queue to store entry set of map with descending order of map's values
Poll top k elements to array

## 1046. Last Stone Weight
Use priority queue to store stone with descending order. Each time poll two times and add their difference to pq

## 973. K Closest Points to Origin
Use priority queue to store arrays with their distance to origin descending orders. Since we we need k closest points, once the size greater than k we poll larger distance elements

## 215. Kth Largest Element in an Array
Put elements of array to priority queue and poll until kth largest came out

## 621. Task Scheduler
Put task into map with occurance descending order.
Define variable total time to record answer. Use priority queue to store all task occurance and deque to record unfinished task.
While loop through when pq is not empty or deque is not empty. Each time looping update total time. If statement to judge if pq is not empty, poll the largest element from pq and -1 to it. If this count is not 0, which means it still needed, we put if into deque as 2D array where other index representing total time + cool down time.
Next we use if statement to judge if deque is not empty and peek of deque's 1 index(which is the time should stop cool down), we push this back to pq since now its needed!

## 295. Find Median from Data Stream
Use two pq to store half of data. PQ1 stores left part data(less) and PQ2 store other halp(larger). PQ1 should descneding order and PQ2 should ascending order. Each time when we add, we put element to PQ1 and poll from PQ1 and add to PQ2. Once PQ2 size greater than PQ1, poll and return back to PQ1 so PQ1 will store 0 or 1 more element than PQ2

## 378. Kth Smallest Element in a Sorted Matrix
We want [1,5,9,10,11,12,13] from [1,5,9,10,11,12,13,13,15] and pop 13. However if we use minHeap, then we need to pop 1,5,9...until last, but if we use maxHeap, we need to know the length and minus k and pop, it's complicated. So we use minHeap to store -matrix[r][c] and maintains minHeap size as k. Then we simply pop -(-13)
