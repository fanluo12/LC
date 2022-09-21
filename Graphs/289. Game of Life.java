class Solution {
    public void gameOfLife(int[][] board) {
        // original - new - state
        //    0     -  0  -    0
        //    1     -  0  -    1
        //    0     -  1  -    2
        //    1     -  1  -    3
        
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[0].length; c ++) {
                int nei = countNeighbors(board, r, c);
                if (board[r][c] == 1) {
                    if (nei == 2 || nei == 3) {
                        board[r][c] = 3;
                    }
                }
                else {
                    if (nei == 3) {
                        board[r][c] = 2;
                    }
                }
            }
        }
        
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[0].length; c ++) {
                if (board[r][c] == 1) {
                    board[r][c] = 0;
                }
                else if (board[r][c] == 2 || board[r][c] == 3) {
                    board[r][c] = 1;
                }
            }
        }
    }
    
    public int countNeighbors(int[][] board, int row, int col) {
        int nei = 0;
        for (int r = row - 1; r <= row + 1; r ++) {
            for (int c = col - 1; c <= col + 1; c ++) {
                if ((r == row && c == col) || r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
                    continue;
                }
                if (board[r][c] == 1 || board[r][c] == 3) {
                    nei ++;
                }
            }
        }
        return nei;
    }
}
