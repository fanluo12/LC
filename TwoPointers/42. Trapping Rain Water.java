class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int res = 0;
        
        while (left < right) {
            if (leftMax < rightMax) {
                left ++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            }
            else {
                right --;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }
        return res;
    }
}
