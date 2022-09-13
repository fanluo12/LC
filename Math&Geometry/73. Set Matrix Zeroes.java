class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        List<Integer> rowSet = new ArrayList<>();
        List<Integer> colSet = new ArrayList<>();
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (matrix[r][c] == 0) {
                    rowSet.add(r);
                    colSet.add(c);
                }
            }
        }
        
        for (int row: rowSet) {
            Arrays.fill(matrix[row], 0);
        }
        
        for (int col: colSet) {
            for (int r = 0; r < ROWS; r ++) {
                matrix[r][col] = 0;
            }
        }
    }
}
