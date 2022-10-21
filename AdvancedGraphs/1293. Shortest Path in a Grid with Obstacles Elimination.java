class Solution {
    
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public int shortestPath(int[][] grid, int k) {
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<int[]> queue = new LinkedList<>();
        // queue will add [row, col, path]
        queue.offer(new int[]{0, 0, 0});
        
        int[][] visited = new int[ROWS][COLS];
        for (int[] row: visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        
        int distance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int[] tmp = queue.poll();
                if (tmp[0] == ROWS - 1 && tmp[1] == COLS - 1) {
                    return distance;
                }
                for (int[] dir: directions) {
                    int newR = tmp[0] + dir[0];
                    int newC = tmp[1] + dir[1];
                    // check boundaries first
                    if (newR < 0 || newC < 0 || newR >= ROWS || newC >= COLS) {
                        continue;
                    }
                    int newK = tmp[2] + grid[newR][newC];
                    // check if exceed k or not
                    if (newK > k) {
                        continue;
                    }
                    // if newK is large, break single loop
                    if (visited[newR][newC] <= newK) {
                        continue;
                    }
                    visited[newR][newC] = newK;
                    queue.offer(new int[]{newR, newC, newK});
                }
            }
            distance ++;
        }
        return -1;
    }
}
