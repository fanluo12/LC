class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int row = 0, col = COLS - 1;
        
        while (row < ROWS && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {
                row ++;
            }
            else {
                col --;
            }
        }
        return false;
    }
}
