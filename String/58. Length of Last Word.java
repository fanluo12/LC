class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            if (s.charAt(i) != ' ') {
                int start = i;
                while (i >= 0 && s.charAt(i) != ' ') {
                    i --;
                }
                res = start - i;
                break;
            }
        }
        return res;
    }
}
