class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int c = 0; c < n; c ++) {
            if (!map.containsKey(grid[0][c])) {
                map.put(grid[0][c], new ArrayList<>());
                map.get(grid[0][c]).add(c);
            }
            else {
                map.get(grid[0][c]).add(c);
            }
        }

        int res = 0;

        for (int r = 0; r < n; r ++) {
            int rowStart = grid[r][0];
            if (map.containsKey(rowStart)) {
                for (int column: map.get(rowStart)) {
                    if (checkSame(grid, r, column, n)) {
                        res ++;
                    }
                }
            }
        }
        return res;
    }

    public boolean checkSame(int[][] grid, int r, int c, int n) {
        for (int i = 0; i < n; i ++) {
            if (grid[r][i] != grid[i][c]) {
                return false;
            }
        }
        return true;
    }
}
