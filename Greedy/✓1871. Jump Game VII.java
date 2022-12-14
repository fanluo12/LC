class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);

        // key for greedy, otherwise ETL
        // we need to update farthest postion after each jump
        // And next jump starts from max(farthest, cur + minJump)
        int farthest = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // having trouble understanding why farthest + 1
            // if not plus 1, this will trigger ETL
            int start = Math.max(cur + minJump, farthest + 1);
            
            for (int end = start; end < Math.min(s.length(), cur + maxJump + 1); end ++) {
                if (s.charAt(end) == '0') {
                    queue.offer(end);
                    if (end == s.length() - 1) {
                        return true;
                    }
                }
            }
            farthest = cur + maxJump;
        }
        return false;
    }
}
