class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int res = 0;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i < m + 1; i ++) {
            for (int j = 1; j < n + 1; j ++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
