class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        
        for (int num: nums) {
            count[num] ++;
        }
        
        for (int i = 1; i <= 100; i ++) {
            count[i] += count[i - 1];
        }
        
        for (int i = 0; i < nums.length; i ++) {
            res[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }
        return res;
    }
}
