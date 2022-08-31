class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, count = 0;
        int minLen = s.length() + 1;
        int minLeft = 0;
        
        for (int right = 0; right < s.length(); right ++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count ++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count --;
                        }
                    }
                    left ++;
                }
            }
        }
        
        if (minLen > s.length()) {
            return new String("");
        }
        
        return s.substring(minLeft, minLeft + minLen);
    }
}
