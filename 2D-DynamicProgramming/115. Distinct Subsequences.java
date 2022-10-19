class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        
        for (int c = 0; c < s.length() + 1; c ++) {
            dp[0][c] = 1;
        }
        
        for (int i = 0; i < t.length(); i ++) {
            for (int j = 0; j < s.length(); j ++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j];
                }
                else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
/* dp array
Take long string as columns and short string as row
  0 r a b b b i t
0 1 1 1 1 1 1 1 1
r 0 1 1 1 1 1 1 1
a 0 0 1 1 1 1 1 1
b 0 0 0 1 2 3 3 3
b 0 0 0 0 1 2 3 3
i 0 0 0 0 0 0 3 3 
t 0 0 0 0 0 0 0 3

loop through each row and column, once we find characters are equal for (i, j) index, we need to add (i - 1, j - 1)(which is previous max result) to (i - 1, j)(which is current updated result for each row)
*/

class Solution2 {
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int c = 0; c <= n; c ++) {
            dp[0][c] = 1;
        }
        
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
