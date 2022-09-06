class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length, COLS = board[0].length;
        int[][] visited = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (backtrack(board, word, visited, ROWS, COLS, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean backtrack(char[][] board, String word, int[][] visited, int ROWS, int COLS, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != word.charAt(index) || visited[r][c] == 1) {
            return false;
        }
        visited[r][c] = 1;
        boolean res = backtrack(board, word, visited, ROWS, COLS, r - 1, c, index + 1) || 
                      backtrack(board, word, visited, ROWS, COLS, r + 1, c, index + 1) ||
                      backtrack(board, word, visited, ROWS, COLS, r, c + 1, index + 1) ||
                      backtrack(board, word, visited, ROWS, COLS, r, c - 1, index + 1);
        visited[r][c] = 0;
        return res;
    }
}
