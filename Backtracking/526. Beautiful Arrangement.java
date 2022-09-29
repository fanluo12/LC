class Solution {
    
    int count = 0;
    
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }
    
    public void backtrack(int n, int start, boolean[] visited) {
        if (start > n) {
            count ++;
            return;
        }
        for (int i = 1; i <= n; i ++) {
            if (!visited[i] && (start % i == 0 || i % start == 0)) {
                visited[i] = true;
                backtrack(n, start + 1, visited);
                visited[i] = false;
            }
        }
    }
}
