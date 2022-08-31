class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int right = 0; right < nums.length; right ++) {
            // pop first if window reaches k
            while (!queue.isEmpty() && queue.peek() < right - k + 1) {
                queue.poll();
            }
            // pop last element if new coming is grater
            while (!queue.isEmpty() && nums[right] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            
            queue.offer(right);
            
            if (right >= k - 1) {
                res[left ++] = nums[queue.peek()];
            }
        }
        return res;
    }
}
