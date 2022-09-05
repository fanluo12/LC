class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        
        // visited array of 2 oceans
        int[][] pacific = new int[ROWS][COLS];
        int[][] atlantic = new int[ROWS][COLS];
        
        for (int r = 0; r < ROWS; r ++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, COLS - 1, atlantic);
        }
        
        for (int c = 0; c < COLS; c ++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, ROWS - 1, c, atlantic);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (pacific[r][c] == 1 && atlantic[r][c] == 1) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }
    
    public void dfs(int[][] heights, int r, int c, int[][] visited) {
        if (visited[r][c] == 1) {
            return;
        }
        visited[r][c] = 1;
        int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
        
        for (int[] dir: directions) {
            if (dir[0] >= 0 && dir[1] >= 0 && dir[0] < heights.length && dir[1] < heights[0].length && heights[dir[0]][dir[1]] >= heights[r][c]) {
                dfs(heights, dir[0], dir[1], visited);
            }
        }
    }
}
