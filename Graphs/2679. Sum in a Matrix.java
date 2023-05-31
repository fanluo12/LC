class Solution {
    public int matrixSum(int[][] nums) {
        int score = 0;

        for (int i = 0; i < nums.length; i ++) {
            Arrays.sort(nums[i]);
        }

        for (int c = 0; c < nums[0].length; c ++) {
            int max = 0;
            for (int r = 0; r < nums.length; r ++) {
                max = Math.max(nums[r][c], max);
            }
            score += max;
        }
        return score;
    }
}
