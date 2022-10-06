class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i ++) {
            if (charArr[i] == '(') {
                stack.push(i);
            }
            else if (charArr[i] == ')') {
                if (!stack.empty()) {
                    stack.pop();
                }
                else {
                    charArr[i] = '*';
                }
            }
        }
        while (!stack.empty()) {
            charArr[stack.pop()] = '*';
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i ++) {
            if (charArr[i] != '*') {
                sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }
}
