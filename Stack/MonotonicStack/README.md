## 907. Sum of Subarray Minimums
Use dp array with one extra space to store dynamic sum
Use stack to store indices. First push -1 to stack
For loop through array, while stack.peek is not -1 and coming element is less than stack.peek, we pop larger element from stack. Then we update dp array, dp[i + 1] = dp[stack.peek + 1](this is the element itself, such as 3, 1,2,4) + (i - stack.peek)(how many small element we should add)*arr[i]
