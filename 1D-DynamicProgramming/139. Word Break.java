class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        for (int start = 0; start < s.length(); start ++) {
            if (dp[start] != 1) {
                continue;
            }
            for (int end = start + 1; end < s.length() + 1; end ++) {
                if (set.contains(s.substring(start, end))) {
                    dp[end] = 1;
                }
            }
        }
        return dp[s.length()] == 1;
    }
}
