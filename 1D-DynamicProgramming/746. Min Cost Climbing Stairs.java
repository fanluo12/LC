// backward
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

// forward
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            return 0;
        }
        if (cost.length < 3) {
            return cost.length == 2 ? Math.min(cost[0], cost[1]) : cost[0];
        }
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = 0; i < n; i ++) {
            dp[i] = cost[i];
        }
        
        for (int i = 2; i < dp.length; i ++) {
            dp[i] += Math.min(dp[i - 2], dp[i - 1]);
        }
        
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
