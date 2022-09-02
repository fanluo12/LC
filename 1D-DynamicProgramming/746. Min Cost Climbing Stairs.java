class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        
        int[] dp = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i ++) {
            dp[i] = cost[i];
        }
        
        for (int i = dp.length - 3; i >= 0; i --) {
            dp[i] += Math.min(dp[i + 1], dp[i + 2]);
        }
        
        return Math.min(dp[0], dp[1]);
    }
}
