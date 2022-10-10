class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0, res = 0;
        long sum = 0;
        
        while (right < nums.length) {
            sum += nums[right];
            while (nums[right] * (right - left + 1) > sum + k) {
                sum -= nums[left];
                left ++;
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;
    }
}
