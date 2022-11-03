class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> res = new ArrayList<>();
        backtrack(digits, res, "", 0, map);
        return res;
    }
    
    public void backtrack(String digits, List<String> res, String tmpStr, int start, Map<Character, String> map) {
        if (tmpStr.length() == digits.length()) {
            res.add(new String(tmpStr));
            return;
        }
        for (int i = start; i < digits.length(); i ++) {
            for (char c: map.get(digits.charAt(start)).toCharArray()) {
                backtrack(digits, res, tmpStr + c, i + 1, map);
            }
        }
    }
}
