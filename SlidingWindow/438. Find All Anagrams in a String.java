class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pCount = new int[26];
        for (char c: p.toCharArray()) {
            pCount[c - 'a'] ++;
        }
        int[] sCount = new int[26];
        int start = 0;
        for (int end = 0; end < s.length(); end ++) {
            sCount[s.charAt(end) - 'a'] ++;
            if (end - start + 1 == p.length()) {
                if (Arrays.equals(sCount, pCount)) {
                    res.add(start);
                }
                sCount[s.charAt(start) - 'a'] --;
                start ++;
            }
            
        }
        return res;
    }
}
