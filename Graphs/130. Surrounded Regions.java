class Solution {
    
    private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        
        // this step converts 4 edges and their connections to T since they cannot be marked as 'X'
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (board[r][c] == 'O' && (r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1)) {
                    convertEdgeToT(board, r, c);
                }
            }
        }
        
        // mark rest 'O' to 'X'
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
        // mark 'T' to 'O'
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    
    public void convertEdgeToT(char[][] board, int r, int c) {
        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O') {
            board[r][c] = 'T';
            for (int[] dir: directions) {
                convertEdgeToT(board, r + dir[0], c + dir[1]);
            }
        }
    }
}
