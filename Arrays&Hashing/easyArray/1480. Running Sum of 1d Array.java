class Solution1 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}

class Solution2 {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        
        int leftRemain = 0;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i --) {
            res[i] = sum - leftRemain;
            leftRemain += nums[i];
        }
        
        return res;
    }
}

class Solution3 {
    public int[] runningSum(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i ++) {
            tmp += nums[i];
            nums[i] = tmp;
        }
        return nums;
    }
}
