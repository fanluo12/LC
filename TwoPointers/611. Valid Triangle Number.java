class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        
        for (int i = nums.length - 1; i >= 2; i --) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right --;
                }
                else {
                    left ++;
                }
            }
        }
        return count;
    }
}
