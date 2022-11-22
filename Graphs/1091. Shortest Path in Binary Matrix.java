class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int[] tmp = queue.poll();
                int r = tmp[0], c = tmp[1], path = tmp[2];
                if (r == n - 1 && c == n - 1) {
                    return path;
                }
                for (int[] dir: directions) {
                    int newR = r + dir[0], newC = c + dir[1];
                    if (0 <= newR && newR < n && 0 <= newC && newC < n && grid[newR][newC] == 0) {
                        grid[newR][newC] = 1;
                        queue.offer(new int[]{newR, newC, path + 1});
                    }
                }
            }
        }
        return -1;
    }
}
