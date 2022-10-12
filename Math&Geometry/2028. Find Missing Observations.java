class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // get sum of m rolls
        int sumOfm = 0;
        for (int roll: rolls) {
            sumOfm += roll;
        }
        
        // get missing sum
        int m = rolls.length;
        int missingSum = mean * (m + n) - sumOfm;
        // if missing sum less than n * 1 or greater than n * 6, return empty array
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        
        // use mean of missing sum / n to populate result array. If there is remainder, make them up to result array
        int meanOfn = missingSum / n, remainder = missingSum % n;
        int[] res = new int[n];
        Arrays.fill(res, meanOfn);
        
        for (int i = 0; i < n; i ++) {
            res[i] += (remainder > 0 ? 1 : 0);
            remainder --;
        }
        return res;
    }
}
