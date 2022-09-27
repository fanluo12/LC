class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] charP = new char[26];
        HashSet<Character> pSet = new HashSet<>();
        for (char c: p.toCharArray()) {
            charP[c - 'a'] ++;
            pSet.add(c);
        }
        String valueOfP = String.valueOf(charP);
        
        for (int start = 0; start <= s.length() - p.length(); start ++) {
            if (!pSet.contains(s.charAt(start))) {
                continue;
            }
            int end = start + p.length() - 1;
            char[] count = new char[26];
            for (int i = start; i <= end; i ++) {
                count[s.charAt(i) - 'a'] ++;
            }
            String tmp = String.valueOf(count);
            if (tmp.equals(valueOfP)) {
                res.add(start);
            }
        }
        return res;
    }
}
