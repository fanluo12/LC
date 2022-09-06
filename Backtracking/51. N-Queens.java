class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] boardRow: board) {
            Arrays.fill(boardRow, '.');
        }
        
        HashSet<Integer> colSet = new HashSet<>();
        HashSet<Integer> posDiagnalSet = new HashSet<>();
        HashSet<Integer> negDiagnalSet = new HashSet<>();
        
        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, board, colSet, posDiagnalSet, negDiagnalSet, res);
        return res;
    }
    
    public void backtrack(int row, int n, char[][] board, HashSet<Integer> colSet, HashSet<Integer> posDiagnalSet, HashSet<Integer> negDiagnalSet, List<List<String>> res) {
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
