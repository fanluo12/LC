class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i ++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count ++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] isConnected, int i, boolean[] visited) {
        for (int j = 0; j < isConnected.length; j ++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, j, visited);
            }
        }
    }
}
