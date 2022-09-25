class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int n: nums) {
            for (int i = n; i < target + 1; i ++) {
                dp[i] += dp[i - n];
            }
        }
        
        return dp[dp.length - 1];
    }
}
