class Solution {
    public char findTheDifference(String s, String t) {
        int[] charArr = new int[26];
        for (char c: t.toCharArray()) {
            charArr[c - 'a'] ++;
        }
        for (char c: s.toCharArray()) {
            charArr[c - 'a'] --;
        }
        for (int i = 0; i < 26; i ++) {
            if (charArr[i] == 1) {
                return (char)('a' + i);
            }
        }
        return t.charAt(0);
    }
}
