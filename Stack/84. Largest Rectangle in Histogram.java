class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] newHeights = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i ++) {
            newHeights[i] = heights[i];
        }
        newHeights[newHeights.length - 1] = 0;
        int max = 0;
        
        for (int i = 0; i < newHeights.length; i ++) {
            while (!stack.empty() && newHeights[stack.peek()] > newHeights[i]) {
                int h = newHeights[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            
            stack.push(i);
        }
        return max;
    }
}
