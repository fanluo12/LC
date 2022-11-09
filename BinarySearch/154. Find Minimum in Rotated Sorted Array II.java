// method similar to 153. Note we need to update left to find minimum and there is duplicate. When mid is greater or equal to left, we update left by +1 not left = mid + 1
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left ++;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}

class Solution2 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right --;
            }
        }
        return nums[left];
    }
}
