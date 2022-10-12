class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String s: sentences) {
            int count = 0;
            for (int i = 0; i < s.length(); i ++) {
                if (s.charAt(i) == ' ') {
                    count ++;
                }
            }
            res = Math.max(res, count + 1);
        }
        return res;
    }
}

// another built-in method
class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String s: sentences) {
            res = Math.max(res, s.split(" ").length);
        }
        return res;
    }
}
