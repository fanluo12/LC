## 20. Valid Parentheses
Use stack to push other side of brackets once meet brackets. For example, when we have ( or ([{ we push ) or )]}. In this case we have unfinished brackets in our stack. If new element(unfinished brackets) is not same with stack.pop(), then it's not valid. Also, if stack is empty() if new element looping, it's also false

## 150. Evaluate Reverse Polish Notation
For loop through string array.
1. Once meet "+", push sum of two element popped from stack
2. Once meet "-", pop 2 element from stack and use last popped one substract first popped one. Push result to stack
3. Once meet "*" and "/" same as above
4. Once meet other situations, push integer of string into stack

## 22. Generate Parentheses
Backtrack to generate parentheses. In backtrack function, use two parameters left and right to generate left and right parenthese. Initialize left and right as n and set end criteria is that left and right are both 0. In each backtrack process, left - 1 if generate "(" and right - 1 if generate ")"
