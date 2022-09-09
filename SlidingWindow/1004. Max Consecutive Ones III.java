class Solution {
    public int longestOnes(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, max = 0, numZero = 0;
        
        for (int right = 0; right < nums.length; right ++) {
            if (nums[right] == 0) {
                numZero ++;
            }
            while (numZero > k) {
                if (nums[left] == 0) {
                    numZero --;
                }
                left ++;
            }
            if (numZero <= k) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}
