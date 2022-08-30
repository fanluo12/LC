## 53. Maximum Subarray
Use two variables, res and tmp. res is initialed as Integer.MIN_VALUE to maximum res and tmp in next steps while tmp a running sum of elements in array.
For loop through array and use tmp to add each element. If tmp < 0 then assign 0 to tmp since negative value would be less if adding negative value so we need to start from 0 to record again the running sum.

