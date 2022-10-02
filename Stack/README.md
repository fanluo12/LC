# 6 total - 09/11/2022

## 20. Valid Parentheses
Use stack to push other side of brackets once meet brackets. For example, when we have ( or ([{ we push ) or )]}. In this case we have unfinished brackets in our stack. If new element(unfinished brackets) is not same with stack.pop(), then it's not valid. Also, if stack is empty() if new element looping, it's also false

## 150. Evaluate Reverse Polish Notation && 224. Basic Calculator && 227. Basic Calculator II
### 150
For loop through string array.
1. Once meet "+", push sum of two element popped from stack
2. Once meet "-", pop 2 element from stack and use last popped one substract first popped one. Push result to stack
3. Once meet "*" and "/" same as above
4. Once meet other situations, push integer of string into stack
### 224
Loop through string
1. Once meet digit character, update cur * 10 + (cur - '0') for two and more digit number case
2. Once meet +, update output with cur * sign since we need to start over. Then assign cur = 0, sign = 1
3. Once meet -, same as + operation
4. Once meet (, push output and sign to integer stack and re-assign output = 0 and sign = 1 for parenthenese inside operation
5. Once meet ), means finish parenthenese inside, we need to update output as cur * sign(inside part), and connect with outside, first * stack.pop(sign), then add stack.pop(last output) and re-assign cur to 0
6. Remember if there are remaining cur, need to update to result
### 227
Still need cur, output and sign(initialize as '+') to tracking result. While character is digit, update cur since there would be two or more digit case. If character is one of 4 signs, push cur and -cur to stack if + or -, stack.pop() * or / if * or /. Remember update cur and sign

## 853. Car Fleet
Use 2D array to represent position and speed for each car and sort them with descending order(from most near the target)
For loop through each array of arrays and calculate time to target position. Note time need to use double data type.
Use stack to store each time. Once upcoming time is <= last time pushed in stack, means upcoming car use less time than previous one and can become fleet, so just continue to overlook them. When to add new one in stack? When the time is greater then previous of stack, means they use long time and cannot make fleet with previous one

## 84. Largest Rectangle in Histogram
For loop through heights array, put index into stack. Once new upcoming height is higher than previous, pop previous and multiply with top of stack(last position lower then previous). In the meantime update max variable for result.
### NOTE
If last element is greater than second last element, then we may not push it into stack. So we have to add 0 to the last index to record increasing height.

## 32. Longest Valid Parentheses
Use stack to store indices
For loop string, once meet '(', push its index to stack. If not '(', if stack is empty then update start index + 1, else compute current longest length

## 94. Decode String
We cannot use for loop to traverse string since we need substring numbers in stack. We use number stack to store numbers and string stack(push an empty string inside first in case to pop and add other string) to store strings.
1. While loop through string. If character is number, we need to find the longest number with another while loop and store into number stack.
2. If character is [, means we need to record computation inside [] and use a new empty string to update. So push this new empty string to string stack
3. If character is ], means computation finish. We need to pop last string from string stack and how many times from number stack. Use stringbuilde to store exactly times of this string and connect to pop element in string stack(usually empty or last string) and push back to string stack
4. If character is letter, connect to string stack.pop and push back

## 841. Keys and Rooms
Use stack to store room number. Each time pop last room and get all keys of this room using rooms.get(room), and add to stack if not visited. We finally check if visited.size() == rooms.size()
