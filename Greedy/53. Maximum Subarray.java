class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, tmp = 0;
        // tmp is convert new element which less than 0 to itself since negative + negative would less and less
        for (int n: nums) {
            if (tmp < 0) {
                tmp = 0;
            }
            tmp += n;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
