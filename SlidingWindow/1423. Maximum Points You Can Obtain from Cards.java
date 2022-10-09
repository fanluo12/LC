class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int runningSum = 0;
        for (int i = 0; i < k; i ++) {
            runningSum += cardPoints[i];
        }
        
        int n = cardPoints.length;
        int res = runningSum;
        for (int rightWindow = k - 1; rightWindow >= 0; rightWindow --) {
            runningSum += cardPoints[rightWindow + n - k] - cardPoints[rightWindow];
            res = Math.max(res, runningSum);
        }
        return res;
    }
}
