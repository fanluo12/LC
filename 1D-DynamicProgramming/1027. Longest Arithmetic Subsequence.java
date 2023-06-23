class Solution {
    public int longestArithSeqLength(int[] nums) {
        if (nums.length == 2) {
            return 2;
        }
        int res = 2;
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
    
        for (int i = 0; i < nums.length; i ++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j ++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }
}
