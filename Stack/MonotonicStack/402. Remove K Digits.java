class Solution {
    public String removeKdigits(String s, int k) {
        if (k == s.length()) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            // use stack to store smaller number, once stack peek is greater, pop and store smaller number in
            while (!stack.empty() && k > 0 && stack.peek() > s.charAt(index)) {
                stack.pop();
                k --;
            }
            stack.push(s.charAt(index));
            index ++;
        }
        
        // if string is ascending order, eg. 1234
        while (k > 0) {
            stack.pop();
            k --;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
        
    }
}
