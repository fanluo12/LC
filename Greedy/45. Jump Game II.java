class Solution {
    public int jump(int[] nums) {
        int res = 0, left = 0, right = 0;
        
        while (right < nums.length - 1) {
            int maxDestination = 0;
            for (int i = left; i < right + 1; i ++) {
                maxDestination = Math.max(maxDestination, nums[i] + i);
            }
            right = maxDestination;
            left ++;
            res ++;
        }
        return res;
    }
}
