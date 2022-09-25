class Solution {
    public int longestSubstring(String s, int k) {
        if (k == 1) {
            return s.length();
        }
        if (s.length() < k) {
            return 0;
        }
        
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a'] ++;
        }
        
        char splitChar = 0;
        for (int i = 0; i < 26; i ++) {
            if (count[i] > 0 && count[i] < k) {
                splitChar = (char)('a' + i);
                break;
            }
        }
        
        if (splitChar == 0) {
            return s.length();
        }
        
        String[] subStrings = s.split(String.valueOf(splitChar));
        int res = 0;
        for (String subString: subStrings) {
            res = Math.max(res, longestSubstring(subString, k));
        }
        
        return res;   
    }
}
