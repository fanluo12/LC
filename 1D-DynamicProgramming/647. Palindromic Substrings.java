class Solution {
    public int countSubstrings(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        
        int res = 0;
        for (int i = 0; i < s.length(); i ++) {
            // odd length
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res ++;
                left --;
                right ++;
            }
            
            // even length
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res ++;
                left --;
                right ++;
            }
        }
        return res;
    }
}
