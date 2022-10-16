// backward
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i --) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] > nums[i]) {
                    res[i] = Math.max(res[i], 1 + res[j]);
                    max = Math.max(max, res[i]);
                }
            }
        }
        return max == 0 ? 1 : max;
    }
}
// forwad
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int max = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                    max = Math.max(max, dp[j]);
                }
            }
        }
        return max == 0 ? 1 : max;
    }
}
