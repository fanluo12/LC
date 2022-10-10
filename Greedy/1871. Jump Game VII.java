class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length(), farthest = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int start = Math.max(cur + minJump, farthest + 1);
            for (int end = start; end < Math.min(cur + maxJump + 1, n); end ++) {
                if (s.charAt(j) == '0') {
                    queue.offer(end);
                    if (end == n - 1) {
                        return true;
                    }
                }
            }
            farthest = cur + maxJump;
        }
        return false;
    }
}
