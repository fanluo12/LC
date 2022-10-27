class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (char c: map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}

// letter array method
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] letterArr = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            letterArr[s.charAt(i) - 'a'] ++;
            letterArr[t.charAt(i) - 'a'] --;
        }
        
        for (int i = 0; i < 26; i ++) {
            if (letterArr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
