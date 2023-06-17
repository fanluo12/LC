class Solution {
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int n = grid.length;
        int color = 2;
        for (int r = 0; r < n; r ++) {
            for (int c = 0; c < n; c ++) {
                if (grid[r][c] == 1) {
                    int area = paint(grid, n, r, c, color);
                    map.put(color, area);
                    color ++;
                }
            }
        }

        int res = map.getOrDefault(2, 0);

        for (int r = 0; r < n; r ++) {
            for (int c = 0; c < n; c ++) {
                if (grid[r][c] == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(r > 0 ? grid[r - 1][c] : 0);
                    set.add(r < n - 1 ? grid[r + 1][c] : 0);
                    set.add(c > 0 ? grid[r][c - 1] : 0);
                    set.add(c < n - 1 ? grid[r][c + 1] : 0);

                    int newArea = 1;
                    for (int colorInSet : set) {
                        newArea += map.get(colorInSet);
                    }
                    res = Math.max(res, newArea);
                }
            }
        }

        return res;
    }

    public int paint(int[][] grid, int n, int r, int c, int color) {
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = color;
        return 1 + paint(grid, n, r + 1, c, color) + paint(grid, n, r - 1, c, color) + paint(grid, n, r, c + 1, color) + paint(grid, n, r, c - 1, color);
    }
}
