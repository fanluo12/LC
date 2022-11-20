class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Deque<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(s);
        boolean found = false;
        
        while (!queue.isEmpty()) {
            if (found) {
                break;
            }
            int size = queue.size();
            for (int j = 0; j < size; j ++) {
                String tmp = queue.poll();
                if (isValid(tmp)) {
                    res.add(tmp);
                    found = true;
                }
                if (!found) {
                    for (int i = 0; i < tmp.length(); i ++) {
                        // break single loop if character is letter
                        if (tmp.charAt(i) != '(' && tmp.charAt(i) != ')') {
                            continue;
                        }
                        String subTmp = tmp.substring(0, i) + tmp.substring(i + 1);
                        if (!visited.contains(subTmp)) {
                            visited.add(subTmp);
                            queue.offer(subTmp);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isValid(String tmp) {
        int count = 0;
        for (char c: tmp.toCharArray()) {
            if (c == '(') {
                count ++;
            }
            else if (c == ')') {
                count --;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
