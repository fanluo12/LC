class Solution {
    public boolean splitString(String s) {
        return backtrack(s, null);
    }
    
    private boolean backtrack(String s, Double prev) {
        double cur = 0;
        for (int i = 0; i < s.length(); i ++) {
            cur = cur * 10 + (s.charAt(i) - '0');
            if (cur >= 10000000000L) {
                return false;
            }
            if (prev == null) {
                if (backtrack(s.substring(i + 1), cur)) {
                    return true;
                }
            }
            else if (cur == prev - 1 && (i == s.length() - 1 || backtrack(s.substring(i + 1), cur))) {
                return true;
            }
            
        }
        return false;
    }
    
}
