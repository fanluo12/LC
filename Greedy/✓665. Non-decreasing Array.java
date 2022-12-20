class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i - 1] > nums[i]) {
                count ++;
                // case 1: [1, 7, 3, 4], at index 2 position, i-2 position can form a non decreasing with i, so we want to change 7 to make i-2, i-1, i non-decreasing for now
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                }
                // case 2: [4, 7, 3, 9], at index 2 position, since i - 2 is greater than i and [i-2, i -1] is non-decreasing, so we want to change i to i-1 to make i-2,i-1,i non-decreasing
                else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1;
    }
}
