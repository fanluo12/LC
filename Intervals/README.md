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

