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
