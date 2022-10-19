class Solution {
    public int maximalSquare(char[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        
        int[][] dp = new int[ROWS][COLS];
        
        for (int r = 0; r < ROWS; r ++) {
            dp[r][0] = matrix[r][0] == '1' ? 1 : 0;
        }
        for (int c = 0; c < COLS; c ++) {
            dp[0][c] = matrix[0][c] == '1' ? 1 : 0;
        }
        
        for (int r = 1; r < ROWS; r ++) {
            for (int c = 1; c < COLS; c ++) {
                if (matrix[r][c] == '1') {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                }
            }
        }
        
        int max = 0;
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                max = Math.max(max, dp[r][c]);
            }
        }
        return max * max;
    }
}
// methods similar to 1277
class Solution2 {
    public int maximalSquare(char[][] matrix) {
        int max = 0, ROWS = matrix.length, COLS = matrix[0].length;
        for (int r = 0; r < ROWS; r ++) {
            max = Math.max(max, matrix[r][0] - '0');
        }
        
        for (int c = 0; c < COLS; c ++) {
            max = Math.max(max, matrix[0][c] - '0');
        }
        
        for (int r = 1; r < ROWS; r ++) {
            for (int c = 1; c < COLS; c ++) {
                if (matrix[r][c] == '1' && matrix[r - 1][c] - '0' > 0 && matrix[r][c - 1] - '0' > 0 && matrix[r - 1][c - 1] - '0' > 0) {
                    matrix[r][c] += Math.min(Math.min(matrix[r - 1][c] - '0', matrix[r][c - 1] - '0'), matrix[r - 1][c - 1] - '0');
                }
                max = Math.max(max, matrix[r][c] - '0');
            }
        }
        return max * max;
    }
}
