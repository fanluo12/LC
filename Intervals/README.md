# 6 total - 01/04/2023

## 57. Insert Interval
Use array list to update interval from intervals when traversing intervals
1. condition 1
```
newInterval: [   ]
intervals[i]:       [   ]
```
So in this case, we add newInterval to list and assign intervals[i] to newInterval. Since original intervals is non-overlapping, so we can simply use this condition to update until the one before last one. Note that after looping all of intervals, there remain one last and this one was assigned as newInterval. Add it to final list outside the loop
2. condition 2
```
newInterval: [   ]
intervals[i]:  [     ]
```
In this case, we need to expand newInterval as large as we can. So we update newInterval as [min(2 starts), max(2 ends)]
3. condition 3
```
newInterval:            [   ]
intervals[i]:  [   ]
```
Simply add intervals[i] to list

## 56. Merge Intervals
Use array list to add interval from intervals
1. Sort intervals with first element ascending order
2. Add first interval to array list
3. Loop through intervals from second interval, if new interval start less than array list last element's end, then replace last element of array list's end with minimum end. If not then just adding new interval

## 435. Non-overlapping Intervals
Sort intervals with first element ascending order
Use a prevEnd variable to compare end element. Initialize prevEnd with intervals[0][1]
Loop throught intervals from 1st index. If intervals[i][0] greater than prevEnd, pass its value to prevEnd. Else, add value to final answer and pass smaller value of prevEnd and intervals[i][1] to prevEnd since we want minimum intervals to remove. If we remain a extremely large end for prevEnd, we need to remove quite a lot intervals

## 452. Minimum Number of Arrows to Burst Balloons
Sort intervals like below:
```
[   ]
  [       ]
       [       ]
             [      ]
```
So we use -inf as end and loop through sorted intervals. For each interval, once its left > end, count ++ and assign its right to end. Note we need to use Integer.compare(a[1], b[1]) instead of a[1] - b[1] to avoid integer overflow for case [[-2147483646,-2147483645],[2147483646,2147483647]]

## 1851. Minimum Interval to Include Each Query
1. Sort intervals first and sort queries for convenience. Note finally we need ordered result, so before sort queries, clone it
2. For each query, we use priority queue to store [interval length, interval[1]]. We use an index start from 0 represents start position of intervals. When looping each query, we need to update index when index < intervals.length and also q >= current interval[0]. If so, update index and put [length, current interval[1]] to pq.
3. After query less than intervals[i][0], we need to remove intervals in pq where pq.peek()[1] < query. Then we put pq.peek() to map if it exists else -1
4. Finally we use map to find cloned results

## 1288. Remove Covered Intervals
```
[       ]
  [    ]
  [  ]
```
Idea likes above. Sort intervals and update right(initial as 0) when looping sorted intervals. Once interval[1] > right, means one interval should be added to final result. Then update final result and right bound
1. Sort intervals with left ascending orders if left boundary different. Else sort with right boundary descending order
2. Deinfe right = 0. For loop through all intervals, if interval right boundary greater than right, assign it to right and update result

## 2409. Count Days Spent Together
### How to Find two intervals overlapped part quickly?
```
int[] A, B;
int start = Math.max(A[0], B[0]);
int end = Math.min(A[1], B[1]);
// Then end - start + 1 is the overlapped part
```
