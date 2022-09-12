class Solution {
    public void rotate(int[][] matrix) {
        // clockwise rotate
        // first swap symmetry, then swap left and right 
        // 1 2 3     7 8 9     7 4 1
        // 4 5 6  => 4 5 6  => 8 5 2
        // 7 8 9     1 2 3     9 6 3
        
        // anticlockwise rotate
        // first reverse left to right, then swap the symmetry
        // 1 2 3     3 2 1     3 6 9
        // 4 5 6  => 6 5 4  => 2 5 8
        // 7 8 9     9 8 7     1 4 7 
        int ROWS = matrix.length, COLS = matrix[0].length;
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = r; c < COLS; c ++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tmp;
            }
        }
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS / 2; c ++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[r][COLS - c - 1];
                matrix[r][COLS - c - 1] = tmp;
            }
        }
    }
}
