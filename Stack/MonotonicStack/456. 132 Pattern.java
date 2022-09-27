class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int middleMax = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i --) {
            if (nums[i] < middleMax) {
                return true;
            }
            while (!stack.empty() && stack.peek() < nums[i]) {
                middleMax = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
