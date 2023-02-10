class Solution {
    public int maxDistance(int[][] grid) {
        // (0, 0), (0, 2), (2, 0), (2, 2)
        //
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (grid[r][c] == 1) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int[] tmp = queue.poll();
                int r = tmp[0], c = tmp[1];
                for (int[] dir: directions) {
                    int newR = r + dir[0], newC = c + dir[1];
                    if (newR >= 0 && newR < ROWS && newC >= 0 && newC < COLS && grid[newR][newC] == 0 && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        queue.offer(new int[]{newR, newC});
                    }
                }
            }
            res ++;
        }
        return res <= 0 ? -1 : res;
    }
}
