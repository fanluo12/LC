class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Deque<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        
        boolean found = false;
        
        while (!queue.isEmpty()) {
            if (found) {
                break;
            }
            int size = queue.size();
            for (int j = 0; j < size; j ++) {
                String cur = queue.poll();
                if (isValid(cur)) {
                    found = true;
                    res.add(cur);
                }
                if (!found) {
                    for (int i = 0; i < cur.length(); i ++) {
                        if (cur.charAt(i) != '(' && cur.charAt(i) != ')') {
                            continue;
                        }
                        String newCur = cur.substring(0, i) + cur.substring(i + 1);
                        if (!visited.contains(newCur)) {
                            visited.add(newCur);
                            queue.offer(newCur);
                        }
                    }
                }
            }
            
        }
        return res;
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                count += 1;
            } else if (c == ')') {
                count -= 1;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
