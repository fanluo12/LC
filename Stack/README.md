# 6 total - 09/11/2022

## 20. Valid Parentheses
Use stack to push other side of brackets once meet brackets. For example, when we have ( or ([{ we push ) or )]}. In this case we have unfinished brackets in our stack. If new element(unfinished brackets) is not same with stack.pop(), then it's not valid. Also, if stack is empty() if new element looping, it's also false

## 150. Evaluate Reverse Polish Notation
For loop through string array.
1. Once meet "+", push sum of two element popped from stack
2. Once meet "-", pop 2 element from stack and use last popped one substract first popped one. Push result to stack
3. Once meet "*" and "/" same as above
4. Once meet other situations, push integer of string into stack

## 853. Car Fleet
Use 2D array to represent position and speed for each car and sort them with descending order(from most near the target)
For loop through each array of arrays and calculate time to target position. Note time need to use double data type.
Use stack to store each time. Once upcoming time is <= last time pushed in stack, means upcoming car use less time than previous one and can become fleet, so just continue to overlook them. When to add new one in stack? When the time is greater then previous of stack, means they use long time and cannot make fleet with previous one

## 84. Largest Rectangle in Histogram
For loop through heights array, put index into stack. Once new upcoming height is higher than previous, pop previous and multiply with top of stack(last position lower then previous). In the meantime update max variable for result.
### NOTE
If last element is greater than second last element, then we may not push it into stack. So we have to add 0 to the last index to record increasing height.
