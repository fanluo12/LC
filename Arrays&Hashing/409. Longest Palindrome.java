class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        
        for (char c: s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count ++;
            }
            else {
                set.add(c);
            }
        }
        
        if (!set.isEmpty()) {
            return count * 2 + 1;
        }
        return count * 2;
    }
}
