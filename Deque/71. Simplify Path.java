class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        String[] strArr = path.split("/");
        for (String s: strArr) {
            if (s.equals("..")) {
                queue.pollLast();
            }
            else if (!s.equals("") && !s.equals(".")) {
                queue.offer(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (queue.isEmpty()) {
            return "/";
        }
        
        while (queue.size() != 0) {
            sb.append("/").append(queue.poll());
        } 
        
        return sb.toString();
    }
}
