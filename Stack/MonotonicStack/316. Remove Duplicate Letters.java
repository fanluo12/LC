class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            map.put(s.charAt(i), i);
        }
        
        HashSet<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i ++) {
            if (visited.contains(s.charAt(i))) {
                continue;
            }
            while (!stack.empty() && s.charAt(i) < stack.peek() && map.get(stack.peek()) > i) {
                visited.remove(stack.peek());
                stack.pop();
            }
            
            stack.push(s.charAt(i));
            visited.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
