class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] res = new int[ROWS][COLS];
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                int newVal = (posToOneDArray(r, c, COLS) + k) % (ROWS * COLS);
                int[] arr = oneDArrayToPos(newVal, COLS);
                res[arr[0]][arr[1]] = grid[r][c];
            }
        }
        return (List)Arrays.asList(res); 
        
    }
    
    private int posToOneDArray(int r, int c, int COLS) {
        return r * COLS + c;
    }
    
    private int[] oneDArrayToPos(int val, int COLS) {
        int[] arr = new int[2];
        arr[0] = val / COLS;
        arr[1] = val % COLS;
        return arr;
    }
}

// method 2
class Solution2 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k %= (m * n);
        
        int begin = m * n - k;
        
        int r = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (r < m * n) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c < n; c ++) {
                int index = (begin + r) % (m * n);
                row.add(grid[index / n][index % n]);
                r ++;
            }
            res.add(row);
        }
        return res;
    }
}
