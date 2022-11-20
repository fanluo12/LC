class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int ROWS = mat.length, COLS = mat[0].length;
        int[][] res = new int[ROWS][COLS];
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        for (int[] row: res) {
            Arrays.fill(row, -1);
        }
        
        Deque<int[]> queue = new LinkedList<>();
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (mat[r][c] == 0) {
                    res[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int[] dir: directions) {
                int newR = tmp[0] + dir[0], newC = tmp[1] + dir[1];
                if (0 <= newR && newR < ROWS && 0 <= newC && newC < COLS && res[newR][newC] == -1) {
                    res[newR][newC] = res[tmp[0]][tmp[1]] + 1;
                    queue.offer(new int[]{newR, newC});
                }
            }
        }
        return res;
    }
}
