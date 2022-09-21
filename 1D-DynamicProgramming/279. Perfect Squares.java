class Solution {
    public int numSquares(int n) {
        if (n < 3) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int largest = (int)Math.pow(n, 0.5);
        int[] coins = new int[largest];
        for (int i = 0; i < largest; i ++) {
            coins[i] = (i + 1) * (i + 1);
        }
        
        for (int i = 0; i < n + 1; i ++) {
            for (int coin: coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i - coin] + 1);
                }
            }
        }
        return dp[n];
    }
}
