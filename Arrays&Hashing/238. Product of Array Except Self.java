class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p1 = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            res[i] = p1;
            p1 *= nums[i];
        }
        
        int p2 = 1;
        for (int i = nums.length - 1; i >= 0; i --) {
            res[i] *= p2;
            p2 *= nums[i];
        }
        return res;
    }
}
