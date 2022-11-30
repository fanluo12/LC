class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        
        boolean[][] visited = new boolean[ROWS][COLS];
        int[][] dp = new int[ROWS][COLS];
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                dfs(matrix, r, c, dp, visited, -1);
            }
        }
        
        int max = 0;
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                max = Math.max(max, dp[r][c]);
            }
        }
        return max;
    }
    
    public int dfs(int[][] matrix, int r, int c, int[][] dp, boolean[][] visited, int prev) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] <= prev) {
            return 0;
        }
        if (visited[r][c]) {
            return dp[r][c];
        }
        
        int path = 1;
        path = Math.max(path, dfs(matrix, r + 1, c, dp, visited, matrix[r][c]) + 1);
        path = Math.max(path, dfs(matrix, r - 1, c, dp, visited, matrix[r][c]) + 1);
        path = Math.max(path, dfs(matrix, r, c + 1, dp, visited, matrix[r][c]) + 1);
        path = Math.max(path, dfs(matrix, r, c - 1, dp, visited, matrix[r][c]) + 1);
        visited[r][c] = true;
        dp[r][c] = path;
        return path;
    }
}
