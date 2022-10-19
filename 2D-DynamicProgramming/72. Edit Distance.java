/*
  0 h o r s e
0 0 1 2 3 4 5
r 1 1 2 2 3 4
o 2 2 1 2 3 4
s 3 3 2 2 2 3
we first initiate first row & col as indices representing how many would change.
For first row, starting from index 1, once characters not matching, cumulately add 1 until matching. Note there left column, above row and left-up position
we need to check to ensure minimum of them been added
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        
        for (int c = 0; c < word1.length() + 1; c ++) {
            dp[0][c] = c;
        }
        for (int r = 0; r < word2.length() + 1; r ++) {
            dp[r][0] = r;
        }
        
        for (int i = 0; i < word2.length(); i ++) {
            for (int j = 0; j < word1.length(); j ++) {
                dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j] + 1, dp[i][j + 1] + 1), dp[i][j] + (word2.charAt(i) == word1.charAt(j) ? 0 : 1));
            }
        }
        return dp[word2.length()][word1.length()];
    }
}
