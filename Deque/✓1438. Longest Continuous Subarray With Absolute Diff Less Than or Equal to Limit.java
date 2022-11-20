class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        
        int left = 0, right = 0, res = 0;
        
        while (right < nums.length) {
            while (!minQ.isEmpty() && nums[right] <= nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            while (!maxQ.isEmpty() && nums[right] >= nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            minQ.offer(right);
            maxQ.offer(right);
            
            while (nums[maxQ.peek()] - nums[minQ.peek()] > limit) {
                left ++;
                if (left > minQ.peek()) {
                    minQ.poll();
                }
                if (left > maxQ.peek()) {
                    maxQ.poll();
                }
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;
    }
}
