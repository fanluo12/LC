class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s: strs) {
            char[] charArray = new char[26];
            for (char c: s.toCharArray()) {
                charArray[c - 'a'] ++;
            }
            String charString = String.valueOf(charArray);
            map.putIfAbsent(charString, new ArrayList<>());
            map.get(charString).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
