## 853. Car Fleet
Use tree map to store distance to target(sorted automatically) as key and speed as value.
For loop through map, once time(distance to target / speed) is greater than previous, update 1 to result variable

## 220. Contains Duplicate III
Use TreeSet to store element.
Loop through array and add element to treeset. Each time initialize floor and ceiling. If they are null and difference between them and current element less than valueDiff, return true. To keep indexDiff, once treeset size greater than k, remove nums[i - k] from treeset

## 1235. Maximum Profit in Job Scheduling
1. Create 3D arr where format is [start time, end time, profit], sort with start time ascending order
2. Use treemap to update result. Initialize treemap as (0,0)
3. Loop through each 3D array, first get previous start time with floorEntry(arr[0]), then get new profit by this entry.getValue() + arr[2]. We then find lastEntry(), if current profit greater than lastEntry.getValue(), put current entry to treemap 
