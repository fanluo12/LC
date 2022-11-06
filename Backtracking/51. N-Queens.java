class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row: board) {
            Arrays.fill(row, '.');
        }
        
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> posDiagnalSet = new HashSet<>();
        Set<Integer> negDiagnalSet = new HashSet<>();
        
        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, board, colSet, posDiagnalSet, negDiagnalSet, res);
        return res;
    }
    
    public void backtrack(int row, int n, char[][] board, Set<Integer> colSet, Set<Integer> posDiagnalSet, Set<Integer> negDiagnalSet, List<List<String>> res) {
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] boardRow: board) {
                tmp.add(new String(boardRow));
            }
            res.add(tmp);
            return;
        }
        
        for (int col = 0; col < n; col ++) {
            if (colSet.contains(col) || posDiagnalSet.contains(row + col) || negDiagnalSet.contains(row - col)) {
                continue;
            }
            colSet.add(col);
            posDiagnalSet.add(row + col);
            negDiagnalSet.add(row - col);
            board[row][col] = 'Q';
            
            backtrack(row + 1, n, board, colSet, posDiagnalSet, negDiagnalSet, res);
            
            colSet.remove(col);
            posDiagnalSet.remove(row + col);
            negDiagnalSet.remove(row - col);
            board[row][col] = '.';
        }
    }
}
