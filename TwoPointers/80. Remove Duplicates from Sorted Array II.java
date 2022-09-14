class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return n;
        }
        
        int left = 0, right = 0;
        
        while (right < n) {
            if (left < 2 || nums[left - 2] != nums[right]) {
                nums[left] = nums[right];
                left ++;
            }
            right ++;
        }
        return left;
    }
}
