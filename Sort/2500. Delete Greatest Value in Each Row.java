class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        for (int r = 0; r < ROWS; r ++) {
            Arrays.sort(grid[r]);
        }

        int sum = 0;
        for (int c = 0; c < COLS; c ++) {
            int colMax = 0;
            for (int r = 0; r < ROWS; r ++) {
                colMax = Math.max(colMax, grid[r][c]);
            }
            sum += colMax;
        }
        return sum;
    }
}
