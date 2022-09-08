class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length - 1];
        
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left ++;
                        }
                        left ++;
                    }
                    else {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right --;
                        }
                        right --;
                    }
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }
}
