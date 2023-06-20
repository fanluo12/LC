class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int window = 2 * k + 1;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (n < window) {
            return res;
        }

        long sum = 0;
        for (int i = 0; i < n; i ++) {
            sum += nums[i];
            if (i >= window) {
                sum -= nums[i - window];
            }
            if (i >= window - 1) {
                res[i - k] = (int) (sum / window);
            }
        }

        return res;
    }
}
