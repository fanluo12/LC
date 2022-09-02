## 347. Top K Frequent Elements
Use map to store each integer's occurance
Use priority queue to store entry set of map with descending order of map's values
Poll top k elements to array

## 1046. Last Stone Weight
Use priority queue to store stone with descending order. Each time poll two times and add their difference to pq

## 973. K Closest Points to Origin
Use priority queue to store arrays with their distance to origin descending orders. Since we we need k closest points, once the size greater than k we poll larger distance elements
