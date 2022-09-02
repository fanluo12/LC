class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        
        int resLength = 0;
        String res = "";
        
        for (int i = 0; i < s.length(); i ++) {
            // odd length
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLength) {
                    resLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left --;
                right ++;
            }
            
            // even length
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLength) {
                    resLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left --;
                right ++;
            }    
        }
        return res;
    }
}
