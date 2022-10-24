class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int timeUsed = arr[0], r = arr[1], c = arr[2];
            if (r == n - 1 && c == n - 1) {
                return timeUsed;
            }
            for (int[] dir: directions) {
                int newRow = r + dir[0], newCol = c + dir[1];
                if (newRow < 0 || newCol < 0 || newRow == n || newCol == n || visited[newRow][newCol]) {
                    continue;
                }
                visited[newRow][newCol] = true;
                pq.offer(new int[]{Math.max(timeUsed, grid[newRow][newCol]), newRow, newCol});
            }
        }
        return 0;
    }
}
