class Solution {
    
    private int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int shortestBridge(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid.length; c ++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c, visited);
                    return bfs(grid, visited);
                }
            }
        }
        return 0;
    }
    
    public void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid.length || grid[r][c] == 0 || visited[r][c]) {
            return;
        }
        
        visited[r][c] = true;
        for (int[] dir: directions) {
            dfs(grid, r + dir[0], c + dir[1], visited);
        }
    }
    
    public int bfs(int[][] grid, boolean[][] visited) {
        int res = 0;
        Deque<int[]> queue = new LinkedList<>();
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid.length; c ++) {
                if (visited[r][c]) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int[] tmp = queue.poll();
                int r = tmp[0], c = tmp[1];
                for (int[] dir: directions) {
                    int newR = r + dir[0], newC =  c + dir[1];
                    if (newR < 0 || newC < 0 || newR >= grid.length || newC >= grid.length || visited[newR][newC]) {
                        continue;
                    }
                    if (grid[newR][newC] == 1) {
                        return res;
                    }
                    visited[newR][newC] = true;
                    queue.offer(new int[]{newR, newC});
                }
            }
            res ++;
        }
        return res;
    }
    
    
}
