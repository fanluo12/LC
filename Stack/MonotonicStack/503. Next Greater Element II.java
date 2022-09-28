class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i ++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        
        for (int i = 0; i < nums.length; i ++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            if (stack.empty()) {
                break;
            }
        }
        return res;
    }
}
