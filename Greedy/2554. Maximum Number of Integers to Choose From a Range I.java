class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] range = new int[n + 1];
        for (int b: banned) {
            if (b >= 1 && b <= n) {
                range[b] ++;
            }
        }

        int curSum = 0;
        int count = 0;
        for (int i = 1; i <= n; i ++) {
            if (range[i] == 0) {
                curSum += i;
                count ++;
                if (curSum == maxSum) {
                    return count;
                }
                else if (curSum > maxSum) {
                    return count - 1;
                }
            }
        }
        return count;
    }
}
