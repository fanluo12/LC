class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        for (int n: nums) {
            freq[n] += n;
        }
        
        int[] dp = new int[10001];
        dp[0] = freq[0];
        dp[1] = freq[1];
        
        for (int i = 2; i < freq.length; i ++) {
            dp[i] = Math.max(dp[i - 2] + freq[i], dp[i - 1]);
        }
        
        return dp[freq.length - 1];
    }
}
