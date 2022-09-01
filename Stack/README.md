## 20. Valid Parentheses
Use stack to push other side of brackets once meet brackets. For example, when we have ( or ([{ we push ) or )]}. In this case we have unfinished brackets in our stack. If new element(unfinished brackets) is not same with stack.pop(), then it's not valid. Also, if stack is empty() if new element looping, it's also false
