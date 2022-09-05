// 2D dp
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
        for (int i = 0; i < s1.length() + 1; i ++) {
            for (int j = 0; j < s2.length() + 1; j ++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                else {
                    dp[i][j] = (i > 0 && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (j > 0 && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
// memo dfs
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return memoDFS(s1, s2, s3, dp, 0, 0);
    }
    
    public boolean memoDFS(String s1, String s2, String s3, int[][] dp, int i, int j) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (dp[i][j] >= 0) {
            return dp[i][j] == 1? true : false;
        }
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && memoDFS(s1, s2, s3, dp, i + 1, j)) {
            res = true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && memoDFS(s1, s2, s3, dp, i, j + 1)) {
            res = true;
        }
        dp[i][j] = (res == true ? 1 : 0);
        return res;
    }
}
