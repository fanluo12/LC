class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // length  res
        //    3.    1
        //.   4.    3(1 + 2)
        //.   5.    6(3 + 3)
        //.   6.    10(6 + 4)
        int res = 0;
        int t = 1;
        
        for (int i = 2; i < nums.length; i ++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                res += t;
                t += 1;
            } else {
                t = 1;
            }
        }
        return res;
    }
}
