class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int[][] dp = new int[ROWS][COLS];
        int[][] visited = new int[ROWS][COLS];
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                dfs(matrix, dp, visited, -1, r, c);
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
    
    public int dfs(int[][] matrix, int[][] dp, int[][] visited, int prev, int r, int c) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] <= prev) {
            return 0;
        }
        if (visited[r][c] == 1) {
            return dp[r][c];
        }
        int path = 1;
        path = Math.max(path, 1 + dfs(matrix, dp, visited, matrix[r][c], r + 1, c));
        path = Math.max(path, 1 + dfs(matrix, dp, visited, matrix[r][c], r - 1, c));
        path = Math.max(path, 1 + dfs(matrix, dp, visited, matrix[r][c], r, c + 1));
        path = Math.max(path, 1 + dfs(matrix, dp, visited, matrix[r][c], r, c - 1));
        
        dp[r][c] = path;
        visited[r][c] = 1;
        return path;
    }
}
