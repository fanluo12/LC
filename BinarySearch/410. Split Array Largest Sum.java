class Solution {
    public int splitArray(int[] nums, int m) {
        int left = nums[0];
        int right = 0;
        for (int n: nums) {
            right += n;
            left = Math.max(left, n);
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countSubArrays(nums, mid) <= m) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public int countSubArrays(int[] nums, int mid) {
        int count = 1, sum = 0;
        for (int n: nums) {
            if (sum + n <= mid) {
                sum += n;
            }
            else {
                sum = n;
                count ++;
            }
        }
        return count;
    }
}
