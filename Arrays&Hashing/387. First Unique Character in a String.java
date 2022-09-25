class Solution {
    public int firstUniqChar(String s) {
        int[] res = new int[26];
        for (char c: s.toCharArray()) {
            res[c - 'a'] ++;
        }
        
        for (int i = 0; i < s.length(); i ++) {
            if (res[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
