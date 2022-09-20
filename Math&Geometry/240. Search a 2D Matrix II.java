class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int r = 0, c = COLS - 1;
        
        while (r <= ROWS - 1 && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            else if (matrix[r][c] < target) {
                r ++;
            }
            else {
                c --;
            }
        }
        return false;
    }
}
