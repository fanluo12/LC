class Solution {
    public boolean canCross(int[] stones) {
        boolean[][] dp = new boolean[stones.length][stones.length + 1];
        dp[0][1] = true;
        
        for (int end = 1; end < stones.length; end ++) {
            for (int start = 0; start < end; start ++) {
                int diff = stones[end] - stones[start];
                // if difference between two units out of bounds or start unit cannot reach end, break single loop
                if (diff < 0 || diff > stones.length || !dp[start][diff]) {
                    continue;
                }
                dp[end][diff] = true;
                // if difference greater than 1, then end can reach diff - 1
                if (diff >= 1) {
                    dp[end][diff - 1] = true;
                }
                // if differenc less than total length, then end can reach diff + 1
                if (diff < stones.length) {
                    dp[end][diff + 1] = true;
                }
                if (end == stones.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
