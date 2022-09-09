class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        
        for (int i = 0; i < n; i ++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int maxSecond = 0, maxFirst = 0, res = 0;
        for (int i = secondLen; i < prefixSum.length - firstLen; i ++) {
            maxSecond = Math.max(maxSecond, prefixSum[i] - prefixSum[i - secondLen]);
            res = Math.max(res, maxSecond + prefixSum[i + firstLen] - prefixSum[i]);
        }
        
        for (int i = firstLen; i < prefixSum.length - secondLen; i ++) {
            maxFirst = Math.max(maxFirst, prefixSum[i] - prefixSum[i - firstLen]);
            res = Math.max(res, maxFirst + prefixSum[i + secondLen] - prefixSum[i]);
        }
        
        return res;
    }
}
