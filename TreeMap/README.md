## 853. Car Fleet
Use tree map to store distance to target(sorted automatically) as key and speed as value.
For loop through map, once time(distance to target / speed) is greater than previous, update 1 to result variable

## 220. Contains Duplicate III
Use TreeSet to store element.
Loop through array and add element to treeset. Each time initialize floor and ceiling. If they are null and difference between them and current element less than valueDiff, return true. To keep indexDiff, once treeset size greater than k, remove nums[i - k] from treeset
