# 5 total - 12/19/2022

## 57. Insert Interval
Use array list to add interval from intervals;
3 conditions to check:
1. new interval less than interval
2. new interval has intersection with interval
3. new intervla greater than interval

## 56. Merge Intervals
Use array list to add interval from intervals
1. Sort intervals with first element ascending order
2. Add first interval to array list
3. Loop through intervals from second interval, if new interval start less than array list last element's end, then replace last element of array list's end with minimum end. If not then just adding new interval

## 435. Non-overlapping Intervals
Sort intervals with first element ascending order
Use a prevEnd variable to compare end element. Initialize prevEnd with intervals[0][1]
Loop throught intervals from 1st index. If intervals[i][0] greater than prevEnd, pass its value to prevEnd. Else, add value to final answer and pass smaller value of prevEnd and intervals[i][1] to prevEnd since we want minimum intervals to remove. If we remain a extremely large end for prevEnd, we need to remove quite a lot intervals

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
